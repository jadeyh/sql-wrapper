package com.yu.wrapper.core.toolkits.utils.lambdaUtils;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.yu.wrapper.annotation.TableColumn;

import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

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

    /**
     * 根据get/set方法的vararg形式获取列名
     */
    @SafeVarargs
    public static <T> String[] getColumnNamesByLambdas(SFunction<T, ?>... funcs) {
        if (funcs == null || funcs.length == 0) {
            return null;
        }
        return Stream.of(funcs).map(func -> getColumnNameByLambda(func)).toArray(String[]::new);
    }

    /**
     * 根据get/set方法List形式获取列名数组
     */
    public static <T> String[] getColumnNamesByLambdas(List<SFunction<T, ?>> funcs) {
        if (ArrayUtil.isEmpty(funcs)) {
            return null;
        }
        return funcs.stream().map(func -> getColumnNameByLambda(func)).toArray(String[]::new);
    }

    /**
     * 根据Field获取列名
     */
    public static String getColumnName(Field field) {
        if (field.isAnnotationPresent(TableColumn.class)) {
            TableColumn tableColumn = field.getAnnotation(TableColumn.class);
            if (StrUtil.isNotBlank(tableColumn.value())) {
                return tableColumn.value();
            }
        }
        return StrUtil.toUnderlineCase(field.getName());
    }

    /**
     * 根据Lambda获取Field
     */
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
