package com.techncat.quantum.app.common.voutils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VOUtils<T> {
    public <T> T copy(Object region, Class<T> targetClazz) throws IllegalAccessException, InstantiationException {
        T target = targetClazz.newInstance();
        BeanUtils.copyProperties(region, target);
        return targetClazz.cast(target);
    }

    public <T> T copy(Object region, Object target, Class<T> targetClazz) {
        BeanUtils.copyProperties(region, target);
        return targetClazz.cast(target);
    }
}
