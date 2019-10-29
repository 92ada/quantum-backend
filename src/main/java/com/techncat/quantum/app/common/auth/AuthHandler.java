package com.techncat.quantum.app.common.auth;

import com.techncat.quantum.app.common.auth.annotation.Visible;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthHandler {

    // 列表加载暂不设定权限识别问题
    public List preloads(String[] authNames, List dataList) throws IllegalAccessException {
        List result = new ArrayList();
        for (Object data : dataList) {
            result.add(preload(authNames, data));
        }
        return result;
    }

    public <T> T preload(String[] authNames, T data) throws IllegalAccessException {
        // 解析 field 然后 set null
        Field[] fields = data.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Visible.class)) {
                Visible anno = field.getAnnotation(Visible.class);
                String[] requireAuthNames = anno.auths().split(",");
                if (!authPass(authNames, requireAuthNames)) {
                    field.set(data, null); // set null if not visible
                }
            }
            field.setAccessible(false);
        }
        return (T) data;
    }

    private boolean authPass(String[] authNames, String[] requireAuthNames) {
        if (requireAuthNames.length == 0) return true;
        for (String i : authNames) {
            for (String j : requireAuthNames) {
                if (i.equals(j)) return true;
            }
        }
        return false;
    }
}
