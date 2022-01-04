package com.yu.wrapper.lambda;

import cn.hutool.core.util.StrUtil;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeanColumnFieldUtil {
    /**
     * 根据类函数获取类的SerializedLambda
     */
    public static <T> SerializedLambda getFieldSerializedLambda(SFunction<T, ?> func) {
        try {
            Method method = func.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(Boolean.TRUE);
            // 利用jdk的SerializedLambda 解析方法引用
            return  (SerializedLambda) method.invoke(func);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据get/set方法名获取字段名
     */
    public static String getFieldNameByMethodName(String methodName) {
        //去除get、set、is前缀
        if (methodName.startsWith("get") || methodName.startsWith("set")) {
            methodName = methodName.substring(3);
        } else if (methodName.startsWith("is")) {
            methodName = methodName.substring(2);
        }
        //首字母转小写
        return StrUtil.lowerFirst(methodName);
    }

    /**
     * 根据get/set方法获取字段名
     */
    public static <T> String getFieldNameByLambda(SFunction<T, ?> func) {
        SerializedLambda serializedLambda = getFieldSerializedLambda(func);
        if (serializedLambda == null) {
            return null;
        }
        String methodName = serializedLambda.getImplMethodName();
        return getFieldNameByMethodName(methodName);
    }

    /**
     * 根据get/set方法获取列名
     */
    public static <T> String getColumnNameByLambda(SFunction<T, ?> func) {
        return getColumnName(getFieldByLambda(func));
    }

    public static String getColumnName(Field field) {
        if (field.isAnnotationPresent(TableId.class)) {
            TableId tableId = field.getAnnotation(TableId.class);
            return tableId.value();
        } else if (field.isAnnotationPresent(TableField.class)) {
            TableField tableField = field.getAnnotation(TableField.class);
            return tableField.value();
        } else {
            return StrUtil.toUnderlineCase(field.getName());
        }
    }

    //
    public static <T> Field getFieldByLambda(SFunction<T, ?> func) {
        try {
            SerializedLambda serializedLambda = getFieldSerializedLambda(func);
            Class c = Class.forName(serializedLambda.getImplClass().replace("/", ".")); //返回的类路径是/隔开的
            String fieldName = getFieldNameByMethodName(serializedLambda.getImplMethodName());
            return c.getDeclaredField(fieldName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
