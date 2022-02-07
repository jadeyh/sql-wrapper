package com.yu.wrapper.core.toolkits.sqlToolkits;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.yu.wrapper.core.toolkits.Constants;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class SqlStringFactory {
    public static SqlString toSqlString(String string) {
        return () -> string;
    }

    public static SqlString toSqlString(List<String> strings) {
        return () -> strings.stream().collect(joining(Constants.COMMA));
    }

    /**
     * 集合获取in表达式 包含括号
     */
    public static SqlString toSqlString(Collection<?> values, Function<Object, String> paramPutAndGetFunction) {
        if (CollectionUtil.isEmpty(values)) {
            return () -> "()";
        }
        String s = values.stream().map(i -> paramPutAndGetFunction.apply(i)).collect(joining(Constants.COMMA, Constants.LEFT_BRACKET, Constants.RIGHT_BRACKET));
        return () -> s;
    }

    /**
     * 数组获取in表达式 包含括号
     */
    public static SqlString toSqlString(Object[] values, Function<Object, String> paramPutAndGetFunction) {
        if (ArrayUtil.isEmpty(values)) {
            return () -> "()";
        }
        return toSqlString(Arrays.asList(values), paramPutAndGetFunction);
    }
}
