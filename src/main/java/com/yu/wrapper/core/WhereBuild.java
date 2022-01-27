package com.yu.wrapper.core;

import java.util.Collection;
import java.util.function.Consumer;

public interface WhereBuild<ImplClass> {

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
     * BETWEEN 值1 AND 值2
     */
    ImplClass between(boolean condition, String column, Object val1, Object val2);

    default ImplClass notBetween(String column, Object val1, Object val2) {
        return notBetween(true, column, val1, val2);
    }

    /**
     * NOT BETWEEN 值1 AND 值2
     */
    ImplClass notBetween(boolean condition, String column, Object val1, Object val2);

    default ImplClass like(String column, Object val) {
        return like(true, column, val);
    }

    /**
     * LIKE '%值%'
     */
    ImplClass like(boolean condition, String column, Object val);

    default ImplClass notLike(String column, Object val) {
        return notLike(true, column, val);
    }

    /**
     * NOT LIKE '%值%'
     */
    ImplClass notLike(boolean condition, String column, Object val);

    default ImplClass likeLeft(String column, Object val) {
        return likeLeft(true, column, val);
    }

    /**
     * LIKE '%值'
     */
    ImplClass likeLeft(boolean condition, String column, Object val);

    default ImplClass likeStringRight(String column, Object val) {
        return likeStringRight(true, column, val);
    }

    /**
     * LIKE '值%'
     */
    ImplClass likeStringRight(boolean condition, String column, Object val);

    default ImplClass isNull(String column) {
        return isNull(true, column);
    }

    /**
     * 字段 IS NULL
     */
    ImplClass isNull(boolean condition, String column);

    default ImplClass isNotNull(String column) {
        return isNotNull(true, column);
    }

    /**
     * 字段 IS NOT NULL
     */
    ImplClass isNotNull(boolean condition, String column);

    default ImplClass in(String column, Collection<?> values) {
        return in(true, column, values);
    }

    /**
     * 字段 IN (value.get(0), value.get(1), ...)
     * 例: in("id", Arrays.asList(1, 2, 3, 4, 5))
     *
     * 注意！集合为空若存在逻辑错误，请在 condition 条件中判断
     * 如果集合为 empty 则不会进行 sql 拼接
     *
     */
    ImplClass in(boolean condition, String column, Collection<?> values);

    default ImplClass in(String column, Object... values) {
        return in(true, column, values);
    }

    /**
     * 字段 IN (v0, v1, ...)
     * 例: in("id", 1, 2, 3, 4, 5)
     *
     * 注意！数组为空若存在逻辑错误，请在 condition 条件中判断
     * 如果动态数组为 empty 则不会进行 sql 拼接
     */
    ImplClass in(boolean condition, String column, Object... values);

    default ImplClass notIn(String column, Collection<?> values) {
        return notIn(true, column, values);
    }

    /**
     * 字段 NOT IN (value.get(0), value.get(1), ...)
     * 例: notIn("id", Arrays.asList(1, 2, 3, 4, 5))
     */
    ImplClass notIn(boolean condition, String column, Collection<?> values);

    default ImplClass notIn(String column, Object... value) {
        return notIn(true, column, value);
    }

    /**
     * 字段 NOT IN (v0, v1, ...)
     * 例: notIn("id", 1, 2, 3, 4, 5)
     */
    ImplClass notIn(boolean condition, String column, Object... values);

    default ImplClass and(Consumer<ImplClass> consumer) {
        return and(true, consumer);
    }

    /**
     * AND 嵌套
     * 例: and(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    ImplClass and(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass and() {
        return and(true);
    };

    /**
     * 拼接 AND
     */
    ImplClass and(boolean condition);

    default ImplClass or(Consumer<ImplClass> consumer) {
        return or(true, consumer);
    }

    /**
     * OR 嵌套
     * 例: or(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    ImplClass or(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass or() {
        return or(true);
    }

    /**
     * 拼接 OR
     */
    ImplClass or(boolean condition);

    default ImplClass nested(Consumer<ImplClass> consumer) {
        return nested(true, consumer);
    }

    /**
     * 正常嵌套 不带 AND 或者 OR
     * 例: nested(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    ImplClass nested(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass not(Consumer<ImplClass> consumer) {
        return not(true, consumer);
    }

    /**
     * not嵌套
     * 例: not(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    ImplClass not(boolean condition, Consumer<ImplClass> consumer);

    default ImplClass not() {
        return not(true);
    };

    /**
     * 拼接 NOT
     */
    ImplClass not(boolean condition);

    default ImplClass applySql(String applySql, Object... values) {
        return applySql(true, applySql, values);
    }

    /**
     * 拼接 sql
     * 会有 sql 注入风险
     * 例1: apply("id = 1")
     * 例2: apply("date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")
     * 例3: apply("date_format(dateColumn,'%Y-%m-%d') = {0}", LocalDate.now())
     */
    ImplClass applySql(boolean condition, String applySql, Object... values);
}
