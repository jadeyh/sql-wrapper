package com.yu.wrapper.core.toolkits.sqlToolkits;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.yu.wrapper.core.toolkits.Constants;

import java.util.Arrays;
import java.util.Collection;

import static java.util.stream.Collectors.joining;

public class SqlStringFactory {
    public static SqlString toSqlString(String s) {
        return () -> s;
    }

    /**
     * 集合获取in表达式 包含括号
     */
    public static SqlString toSqlString(Collection<?> values, ParamMap paramMap) {
        if (CollectionUtil.isEmpty(values)) {
            return () -> "()";
        }
        return () -> values.stream().map(i -> paramMap.putAndGetKey(i))
                .collect(joining(Constants.COMMA, Constants.LEFT_BRACKET, Constants.RIGHT_BRACKET));
    }

    /**
     * 数组获取in表达式 包含括号
     */
    public static SqlString toSqlString(Object[] values, ParamMap paramMap) {
        if (ArrayUtil.isEmpty(values)) {
            return () -> "()";
        }
        return toSqlString(Arrays.asList(values), paramMap);
    }
}
