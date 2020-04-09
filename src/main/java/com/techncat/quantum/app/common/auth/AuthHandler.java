package com.techncat.quantum.app.common.auth;

import com.techncat.quantum.app.common.auth.annotation.Visible;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthHandler {

    // 列表加载暂不设定权限识别问题
    public List preloads(Visible.ROLE[] roles, List dataList) throws IllegalAccessException {
        List result = new ArrayList();
        for (Object data : dataList) {
            result.add(preload(roles, data));
        }
        return result;
    }

    public <T> T preload(Visible.ROLE[] roles, T data) throws IllegalAccessException {
        // 解析 field 然后 set null
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Visible.class)) {
                Visible anno = field.getAnnotation(Visible.class);
                Visible.ROLE[] requiredRoles = anno.requiredRoles();
                if (!authPass (roles, requiredRoles)) {
                    field.set(data, null); // set null if not visible
                }
            }
            field.setAccessible(false);
        }
        return (T) data;
    }

    private boolean authPass(Visible.ROLE[] roles, Visible.ROLE[] requiredRoles) {
        if (requiredRoles.length == 0) return true;
        for (Visible.ROLE i : roles) {
            for (Visible.ROLE j : requiredRoles) {
                if (i == j) return true;
            }
        }
        return false;
    }
}
