package com.aaron.util;


import java.lang.reflect.Field;

/**
 * Created by pzw on 2/2/2016.
 */
public class ReflectUtil {
    public ReflectUtil() {
    }

    public static Field getFieldByFieldName(Object obj, String fieldName) {
        Field field = null;
        Class clazz = obj.getClass();

        while(clazz != Object.class) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException var5) {
                clazz = clazz.getSuperclass();
            }
        }

        return field;
    }

    public static <T> T getValueByFieldName(Object obj, String fieldName) {
        Object result = null;
        Field field = getFieldByFieldName(obj, fieldName);
        if(field != null) {
            field.setAccessible(true);

            try {
                result = field.get(obj);
            } catch (IllegalArgumentException var5) {
                //LoggerFactory.getLogger(ReflectUtil.class).error("error", var5);
            } catch (IllegalAccessException var6) {
                //LoggerFactory.getLogger(ReflectUtil.class).error("error", var6);
            }
        }

        return (T)result;
    }

    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field field = getFieldByFieldName(obj, fieldName);
        if(field.isAccessible()) {
            field.set(obj, value);
        } else {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        }

    }
}

