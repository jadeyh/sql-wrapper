package com.yu.wrapper.core.lambda;

import com.yu.wrapper.lambdaUtils.BeanColumnFieldUtil;
import com.yu.wrapper.lambdaUtils.SFunction;

import java.util.stream.Stream;

public interface GetByLambda {
    default <T> String getColumnName(SFunction<T, ?> func) {
        return BeanColumnFieldUtil.getColumnNameByLambda(func);
    }

    default <T> String[] getColumnNames(SFunction<T, ?>... funcs) {
        if (funcs == null || funcs.length == 0) {
            return null;
        }
        return Stream.of(funcs).map(func -> getColumnName(func)).toArray(String[]::new);
    }
}
