package com.techncat.quantum.app.auth.resolver;

import com.techncat.quantum.app.auth.annotation.ForkiAser;
import com.techncat.quantum.app.auth.entity.Aser;
import com.techncat.quantum.app.auth.service.JwtService;
import com.techncat.quantum.app.model.user.User;
import com.techncat.quantum.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.util.List;


@Component
public class AserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return (methodParameter.getParameterType().isAssignableFrom(Aser.class) && methodParameter.hasParameterAnnotation(ForkiAser.class));
    }


    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        String token = nativeWebRequest.getHeader("Authorization");
        if (token == null || token.trim().length() == 0)
            throw new AserDecodeException(token);
        Aser aser = jwtService.decode(token);
        if (aser == null)
            throw new AserDecodeException(token);
        if (aser.isExpiration())
            throw new AserDecodeException(token);
        // refetch aser roles, 可能存在用户未更新 TOKEN，但权限更新的情况
        User user = userService.fetch(aser.getSid());

        Annotation[] methodAnnotations = methodParameter.getParameterAnnotations();
        for (Annotation methodAnnotation : methodAnnotations) {
            if (methodAnnotation instanceof ForkiAser) {
                // 角色检验
                ForkiAser forkiAser = (ForkiAser) methodAnnotation;
//                if (isRoleRequireSuccess(forkiAser.requiredRoles(), aser.getRoles())) {
                if (isRoleRequireSuccess(forkiAser.requiredRoles(), user.getRoles())) {
                    return aser;
                } else {
                    throw new AserNoAuthException(forkiAser.requiredRoles());
                }
            }
        }
        return aser;
    }

    private boolean isRoleRequireSuccess(String[] requiredRoles, List<String> userRoles) {
        if (requiredRoles.length == 0) return true; // require nothing
        for (String requiredRole : requiredRoles) {
            for (String userRole : userRoles) {
                if (userRole.equals(requiredRole)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class AserDecodeException extends Exception {
        AserDecodeException(String token) {
            super("TOKEN Decode Fail, token: " + token);
        }
    }

    public static class AserExpirationException extends Exception {
        AserExpirationException(String token) {
            super("TOKEN Expiration, token: " + token);
        }
    }

    public static class AserNoAuthException extends Exception {
        AserNoAuthException(String[] requiredRoles) {
            super("Role required: " + String.join(", ", requiredRoles));
        }
    }
}
