package com.yu.wrapper.core;

import java.util.Collection;
import java.util.function.Consumer;

public interface WhereBuild<ImplClass extends WhereBuild<ImplClass>> {
    default ImplClass eq(String column, Object val) {
        return eq(true, column, val);
    }

    ImplClass eq(boolean condition, String column, Object val);

    default ImplClass ne(String column, Object val) {
        return ne(true, column, val);
    }

    /**
     * 不等于
     */
    ImplClass ne(boolean condition, String column, Object val);

    default ImplClass gt(String column, Object val) {
        return gt(true, column, val);
    }

    /**
     * 大于
     */
    ImplClass gt(boolean condition, String column, Object val);

    default ImplClass ge(String column, Object val) {
        return ge(true, column, val);
    }

    /**
     * 大于等于
     */
    ImplClass ge(boolean condition, String column, Object val);

    default ImplClass lt(String column, Object val) {
        return lt(true, column, val);
    }

    /**
     * 小于
     */
    ImplClass lt(boolean condition, String column, Object val);

    default ImplClass le(String column, Object val) {
        return le(true, column, val);
    }

    /**
     * 小于等于
     */
    ImplClass le(boolean condition, String column, Object val);

    default ImplClass between(String column, Object val1, Object val2) {
        return between(true, column, val1, val2);
    }

    /**
     * BETWEEN value1 AND value2
     */
    ImplClass between(boolean condition, String column, Object val1, Object val2);

    default ImplClass notBetween(String column, Object val1, Object val2) {
        return notBetween(true, column, val1, val2);
    }

    /**
     * NOT BETWEEN value1 AND value2
     */
    ImplClass notBetween(boolean condition, String column, Object val1, Object val2);

    default ImplClass like(String column, Object val) {
        return like(true, column, val);
    }

    /**
     * LIKE '%value%'
     */
    ImplClass like(boolean condition, String column, Object val);

    default ImplClass notLike(String column, Object val) {
        return notLike(true, column, val);
    }

    /**
     * NOT LIKE '%value%'
     */
    ImplClass notLike(boolean condition, String column, Object val);

    default ImplClass likeLeft(String column, Object val) {
        return likeLeft(true, column, val);
    }

    /**
     * LIKE '%value'
     */
    ImplClass likeLeft(boolean condition, String column, Object val);

    default ImplClass likeRight(String column, Object val) {
        return likeRight(true, column, val);
    }

    /**
     * LIKE 'value%'
     */
    ImplClass likeRight(boolean condition, String column, Object val);

    default ImplClass isNull(String column) {
        return isNull(true, column);
    }

    /**
     * IS NULL
     */
    ImplClass isNull(boolean condition, String column);

    default ImplClass isNotNull(String column) {
        return isNotNull(true, column);
    }

    /**
     * IS NOT NULL
     */
    ImplClass isNotNull(boolean condition, String column);

    default ImplClass in(String column, Collection<?> values) {
        return in(true, column, values);
    }

    /**
     * IN (values)
     * 集合为空是逻辑错误的，如果动态数组为empty则不会进行sql拼接
     */
    ImplClass in(boolean condition, String column, Collection<?> values);

    default ImplClass in(String column, Object... values) {
        return in(true, column, values);
    }

    /**
     * IN (value1, value2, ...)
     * 数组为空是逻辑错误的，如果动态数组为empty则不会进行sql拼接
     */
    ImplClass in(boolean condition, String column, Object... values);

    default ImplClass notIn(String column, Collection<?> values) {
        return notIn(true, column, values);
    }

    /**
     * 字段 NOT IN (values)
     */
    ImplClass notIn(boolean condition, String column, Collection<?> values);

    default ImplClass notIn(String column, Object... value) {
        return notIn(true, column, value);
    }

    /**
     * NOT IN (value1, value2, ...)
     */
    ImplClass notIn(boolean condition, String column, Object... values);

    default ImplClass and(Consumer<ImplClass> consumer) {
        return and(true, consumer);
    }

    /**
     * AND嵌套
     */
    ImplClass and(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass and() {
        return and(true);
    };

    /**
     * 拼接AND
     */
    ImplClass and(boolean condition);

    default ImplClass or(Consumer<ImplClass> consumer) {
        return or(true, consumer);
    }

    /**
     * OR嵌套
     */
    ImplClass or(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass or() {
        return or(true);
    }

    /**
     * 拼接OR
     */
    ImplClass or(boolean condition);

    default ImplClass nested(Consumer<ImplClass> consumer) {
        return nested(true, consumer);
    }

    /**
     * 嵌套（其实就是括号）
     */
    ImplClass nested(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass not(Consumer<ImplClass> consumer) {
        return not(true, consumer);
    }

    /**
     * NOT嵌套，其实就是not括号
     */
    ImplClass not(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass not() {
        return not(true);
    };

    /**
     * 拼接NOT
     */
    ImplClass not(boolean condition);

    default ImplClass apply(String applySql, Object... values) {
        return apply(true, applySql, values);
    }

    /**
     * 拼接sql，有sql注入风险
     */
    ImplClass apply(boolean condition, String applySql, Object... values);

    default ImplClass exists(String existsSql, Object... values) {
        return exists(true, existsSql, values);
    }

    /**
     * NOT EXISTS (sql)
     */
    ImplClass exists(boolean condition, String existsSql, Object... values);

    /**
     * ignore
     */
    default ImplClass notExists(String existsSql, Object... values) {
        return notExists(true, existsSql, values);
    }

    /**
     * NOT EXISTS (sql)
     */
    ImplClass notExists(boolean condition, String existsSql, Object... values);
}
