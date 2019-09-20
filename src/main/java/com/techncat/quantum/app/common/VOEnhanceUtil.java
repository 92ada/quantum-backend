package com.techncat.quantum.app.common;

import com.sun.tools.javac.util.ArrayUtils;
import com.techncat.quantum.app.common.annotation.ValueType;
import com.techncat.quantum.app.common.vo.EnhancedVO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class VOEnhanceUtil {

    public List<EnhancedVO> enhance(Object object) throws IllegalAccessException {
        Field[] childFields = object.getClass().getDeclaredFields();
        Field[] fatherFields = object.getClass().getSuperclass().getDeclaredFields();
        Field[] fields = concat(fatherFields, childFields);
        List<EnhancedVO> vos = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            TypeResult typeResult = getType(field);
            String index = field.getName();
            Object value = field.get(object);
            String value_ = null;
            if (null != value) {
                value_ = value.toString();
            }
            switch (typeResult.getValue()) {
                case enumerated:
                    Object[] enumValue = getEnumValues(field);
                    vos.add(new EnhancedVO(index, value_, typeResult.getValue().name(), enumValue));
                    break;
                case object:
                    if (!isEmpty(typeResult.getOptionUrl())){
                        vos.add(new EnhancedVO(index, value_, typeResult.getValue().name(), typeResult.getOptionUrl()));
                        break;
                    }
                case bool:
                case date:
                case number:
                case string:
                default:
                    vos.add(new EnhancedVO(index, value_, typeResult.getValue().name()));
            }
            field.setAccessible(false);
        }
        return vos;
    }

    private TypeResult getType(Field field) {
        Class type = field.getType();
        if (field.isAnnotationPresent(ValueType.class)) {
            ValueType anno = field.getAnnotation(ValueType.class);
            String optionUrl = anno.option_url();
            if ("".equals(optionUrl)) {
                return new TypeResult(anno.value());
            } else {
                return new TypeResult(anno.value(), optionUrl);
            }
        } else {
            if (type == Date.class) {
                return new TypeResult("date");
            } else if (type == Long.class || type == Integer.class || type == Float.class || type == Double.class || type == BigDecimal.class) {
                return new TypeResult("number");
            } else if (type == String.class) {
                return new TypeResult("string");
            } else if (type.isEnum()) {
                return new TypeResult("enumerated");
            } else { // object
                return new TypeResult("object");
            }
        }
    }

    private Object[] getEnumValues(Field field) {
        Class typeClass = field.getType();
        return typeClass.getEnumConstants();
    }

    private boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

    private static class TypeResult {
        static enum Type {
            string,
            number,
            bool,
            date,
            enumerated,
            object,
            phone,
            email
        }
        private Type value;
        private String optionUrl;

        public TypeResult(String value) {
            this.value = Type.valueOf(value);
        }

        public TypeResult(String value, String optionUrl) {
            this.value = Type.valueOf(value);
            this.optionUrl = optionUrl;
        }

        public Type getValue() {
            return value;
        }

        public void setValue(Type value) {
            this.value = value;
        }

        public String getOptionUrl() {
            return optionUrl;
        }

        public void setOptionUrl(String optionUrl) {
            this.optionUrl = optionUrl;
        }
    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

}
