### About Aser

`Aser` 是基于 HTTP 请求拦截过程加的一次权限验证，验证通过则赋值给 `Aser` 实例，否则拒绝该 HTTP 请求。

HTTP 过程：

1. 建立 TCP 连接
2. 分配 HTTP 请求线程
3. 执行请求
4. 返回请求结果
5. 关闭 TCP 连接

`Tomcat` / `Jetty` / `Nginx` 干了 1、2、5
`SpringBoot` 干了 3、4

在 `SpringBoot` 执行的时候流程是：

1. 接受 HTTP 请求
2. 匹配路由
3. 匹配 Controller
4. 你的业务逻辑代码（略）
5. 通过 Controller 返回一个 HttpResponse 结果

但是 `OOP` 有的时候不那么好使嘛，所以有个 `AOP` 嘛，肯定是要 `AOP` 的，这辈子都要 `AOP` 的。

于是 `SpringMVC` 支持在 `controller` 前后分别做拦截、在路由前后做拦截

这里我们要自动把用户信息注入到 `controller` 方法参数里面，所以我们需要在路由后、`controller` 前操作一下。`SpringMVC` 提供了 `addArgumentResolvers/1` 方法来做方法参数注入的逻辑添加：
```java
public class WebInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(你自己定义的第一个拦截器);
        argumentResolvers.add(你自己定义的第二个拦截器);
        argumentResolvers.add(你自己定义的第三个拦截器);
        argumentResolvers.add(new MyMethodArgumentResolver());
    }
}
```
然后创建一个自定义的拦截器：
```java
public class MyMethodArgumentResolver implements HandlerMethodArgumentResolver{
    public boolean supportsParameter(MethodParameter methodParameter){
        // 返回值决定是否执行该拦截器
        // 比如判断只注入有 @ForkiAser 注解的方法参数，没有这个注解就不执行这个拦截器的逻辑
    }   
    public Object resolveArgument(MethodParameter methodParameter,
                                      ModelAndViewContainer modelAndViewContainer,
                                      NativeWebRequest nativeWebRequest,
                                      WebDataBinderFactory webDataBinderFactory) {
        // 你的逻辑
        // 返回值就是注入给那个参数的值
        // 比如 return 1; 则那个参数的值就是 1
        // 又比如：通过 NativeWebRequest 来获取 Http Header 信息，根据 Header 的 token 字段判断用户身份，然后获取用户的权限信息判断用户是否有权限访问对应的接口，如果无权访问就抛异常报错 401
    }
}
```

然后看一下在 `controller` 里面咋用：
```java
//...
public class MeController {
    // 没权限根本进不来这个 controller，因为被拦截器拦截在外面了
    @GetMapping("/me")
    public ResponseEntity showMyInfo(@ForkiAser Aser aser) {
        return ResponseEntity.ok(peopleShowService.fetchBySid(aser.getSid()));
    }
    
    // 没权限根本进不来这个 controller，因为被拦截器拦截在外面了
    @GetMapping("/people/students")
    public ResponseEntity listPeopleStudents(@ForkiAser(requiredRoles = {"people_student"}) Aser aser) {
        return xxx;
    }

    // 没权限根本进不来这个 controller，因为被拦截器拦截在外面了
    // 多个权限是 or 关系，只要满足一个就能进来
    @GetMapping("/people/students")
    public ResponseEntity listPeopleStudents(@ForkiAser(requiredRoles = {"people_student", "export_excel"}) Aser aser) {
        return xxx;
    }
    
    // 没权限根本进不来这个 controller，因为被拦截器拦截在外面了
    @GetMapping("/test")
    public ResponseEntity showMyInfo(@ForkiAser Aser aser) {
        List<String> roles = aser.getRoles(); // 这个人的权限列表
        String       sid   = aser.getSid();   // 工号
        // ...自己的逻辑处理（略）
        return xxx;
    }
}

```

可以再优化的地方：
`ForkiAser` 的 `requiredRoles` 字段是 `List<String>` 类型的，最好能换成 `List<ROLE>` 枚举类型，就不怕打错字了。