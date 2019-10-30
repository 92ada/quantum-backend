package com.techncat.quantum.app.common.voutils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VOUtils {
    public <T> T copy(Object region, Class<T> targetClazz) throws BeanCopyException {
        T target = null;
        try {
            target = targetClazz.newInstance();
            BeanUtils.copyProperties(region, target);
            return targetClazz.cast(target);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanCopyException(targetClazz.getName());
        }
    }

    public <T> T copy(Object region, Object target, Class<T> targetClazz) {
        BeanUtils.copyProperties(region, target);
        return targetClazz.cast(target);
    }

    public class BeanCopyException extends Exception {
        BeanCopyException(String className) {
            super("Class [" + className + "] can not be copied");
        }
    }
}
