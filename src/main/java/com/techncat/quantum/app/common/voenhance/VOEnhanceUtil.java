package com.techncat.quantum.app.common.voenhance;

import com.alibaba.fastjson.JSON;
import com.techncat.quantum.app.common.voenhance.annotation.Editable;
import com.techncat.quantum.app.common.voenhance.annotation.ValueType;
import com.techncat.quantum.app.common.voenhance.vo.EnhancedVO;
import com.techncat.quantum.app.common.voutils.VOUtils;
import com.techncat.quantum.app.model.people.People;
import com.techncat.quantum.app.vos.people.LabVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * 仅作用一个对象，不可作用于 List
 */
@Service
public class VOEnhanceUtil {
    @Autowired
    private VOUtils voUtils;

    public Map<String, Object> enhance(String key, Object object) throws IllegalAccessException {
        List<EnhancedVO> list = enhance(object);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(key, list);
        return map;
    }

    public List<EnhancedVO> enhance(Object object) throws IllegalAccessException {
        Field[] childFields = object.getClass().getDeclaredFields();
//        Field[] fatherFields = object.getClass().getSuperclass().getDeclaredFields();
//        Field[] fields = concat(fatherFields, childFields);
        List<EnhancedVO> vos = new ArrayList<>();
        for (Field field : childFields) {
            field.setAccessible(true);
            TypeResult typeResult = getType(field);
            Boolean isEditable = getEditable(field);
            String index = field.getName();
            Object value = field.get(object);
            EnhancedVO vo;
            switch (typeResult.getValue()) {
                case enumerated:
                    Object[] enumValue = getEnumValues(field);
                    vo = new EnhancedVO(index, value, typeResult.getValue().name(), enumValue);
                    vo.setEditable(isEditable);
                    vos.add(vo);
                    break;
                case lab:
                    if (!isEmpty(typeResult.getOptionUrl())) {
//                        vo = new EnhancedVO(index, JSON.toJSONString(value), typeResult.getValue().name(), typeResult.getOptionUrl());
                        LabVO labVO = voUtils.copy(value, LabVO.class);
                        People people = labVO.getPi();
                        if (people != null) {
                            people.setPeopleAdmin(null);
                            people.setPeoplePostdoctoral(null);
                            people.setPeopleResearcher(null);
                            people.setPeopleStudent(null);
                            people.setPeopleTeacher(null);
                            people.setPeopleVisitor(null);
                            people.setLab(null);
                        }
                        vo = new EnhancedVO(index, labVO, typeResult.getValue().name(), typeResult.getOptionUrl());
                        vo.setEditable(isEditable);
                        vos.add(vo);
                        break;
                    }
                case people:
                case object:
                    if (!isEmpty(typeResult.getOptionUrl())) {
//                        vo = new EnhancedVO(index, JSON.toJSONString(value), typeResult.getValue().name(), typeResult.getOptionUrl());
                        vo = new EnhancedVO(index, value, typeResult.getValue().name(), typeResult.getOptionUrl());
                        vo.setEditable(isEditable);
                        vos.add(vo);
                        break;
                    }
                case bool:
                case date:
                case number:
                case string:
                default:
                    vo = new EnhancedVO(index, value, typeResult.getValue().name());
                    vo.setEditable(isEditable);
                    vos.add(vo);
            }
            field.setAccessible(false);
        }
        return vos;
    }

    private Boolean getEditable(Field field) {
        if (field.isAnnotationPresent(Editable.class)) {
            Editable anno = field.getAnnotation(Editable.class);
            return anno.value();
        }
        return true;
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
            } else if (type == Boolean.class) {
                return new TypeResult("bool");
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

    private Boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }

    private static class TypeResult {
        enum Type {
            string,
            number,
            bool,
            date,
            text,
            enumerated,
            object,
            phone,
            email,
            photo,
            people,
            lab
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
