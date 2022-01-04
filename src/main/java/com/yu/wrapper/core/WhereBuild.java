package com.yu.wrapper.core;

import java.util.Collection;
import java.util.function.Consumer;

public interface WhereBuild {

    default WhereBuild eq(String column, Object val) {
        return eq(true, column, val);
    }

    WhereBuild eq(boolean condition, String column, Object val);

    default WhereBuild ne(String column, Object val) {
        return ne(true, column, val);
    }

    /**
     * 不等于
     */
    WhereBuild ne(boolean condition, String column, Object val);

    default WhereBuild gt(String column, Object val) {
        return gt(true, column, val);
    }

    /**
     * 大于
     */
    WhereBuild gt(boolean condition, String column, Object val);

    default WhereBuild ge(String column, Object val) {
        return ge(true, column, val);
    }

    /**
     * 大于等于
     */
    WhereBuild ge(boolean condition, String column, Object val);

    default WhereBuild lt(String column, Object val) {
        return lt(true, column, val);
    }

    /**
     * 小于
     */
    WhereBuild lt(boolean condition, String column, Object val);

    default WhereBuild le(String column, Object val) {
        return le(true, column, val);
    }

    /**
     * 小于等于
     */
    WhereBuild le(boolean condition, String column, Object val);

    default WhereBuild between(String column, Object val1, Object val2) {
        return between(true, column, val1, val2);
    }

    /**
     * BETWEEN 值1 AND 值2
     */
    WhereBuild between(boolean condition, String column, Object val1, Object val2);

    default WhereBuild notBetween(String column, Object val1, Object val2) {
        return notBetween(true, column, val1, val2);
    }

    /**
     * NOT BETWEEN 值1 AND 值2
     */
    WhereBuild notBetween(boolean condition, String column, Object val1, Object val2);

    default WhereBuild like(String column, Object val) {
        return like(true, column, val);
    }

    /**
     * LIKE '%值%'
     */
    WhereBuild like(boolean condition, String column, Object val);

    default WhereBuild notLike(String column, Object val) {
        return notLike(true, column, val);
    }

    /**
     * NOT LIKE '%值%'
     */
    WhereBuild notLike(boolean condition, String column, Object val);

    default WhereBuild likeLeft(String column, Object val) {
        return likeLeft(true, column, val);
    }

    /**
     * LIKE '%值'
     */
    WhereBuild likeLeft(boolean condition, String column, Object val);

    default WhereBuild likeStringight(String column, Object val) {
        return likeStringight(true, column, val);
    }

    /**
     * LIKE '值%'
     */
    WhereBuild likeStringight(boolean condition, String column, Object val);

    default WhereBuild isNull(String column) {
        return isNull(true, column);
    }

    /**
     * 字段 IS NULL
     */
    WhereBuild isNull(boolean condition, String column);

    default WhereBuild isNotNull(String column) {
        return isNotNull(true, column);
    }

    /**
     * 字段 IS NOT NULL
     */
    WhereBuild isNotNull(boolean condition, String column);

    default WhereBuild in(String column, Collection<?> coll) {
        return in(true, column, coll);
    }

    /**
     * 字段 IN (value.get(0), value.get(1), ...)
     * 例: in("id", Arrays.asList(1, 2, 3, 4, 5))
     *
     * 注意！集合为空若存在逻辑错误，请在 condition 条件中判断
     * 如果集合为 empty 则不会进行 sql 拼接
     *
     */
    WhereBuild in(boolean condition, String column, Collection<?> coll);

    default WhereBuild in(String column, Object... values) {
        return in(true, column, values);
    }

    /**
     * 字段 IN (v0, v1, ...)
     * 例: in("id", 1, 2, 3, 4, 5)
     *
     * 注意！数组为空若存在逻辑错误，请在 condition 条件中判断
     * 如果动态数组为 empty 则不会进行 sql 拼接
     */
    WhereBuild in(boolean condition, String column, Object... values);

    default WhereBuild notIn(String column, Collection<?> coll) {
        return notIn(true, column, coll);
    }

    /**
     * 字段 NOT IN (value.get(0), value.get(1), ...)
     * 例: notIn("id", Arrays.asList(1, 2, 3, 4, 5))
     */
    WhereBuild notIn(boolean condition, String column, Collection<?> coll);

    default WhereBuild notIn(String column, Object... value) {
        return notIn(true, column, value);
    }

    /**
     * 字段 NOT IN (v0, v1, ...)
     * 例: notIn("id", 1, 2, 3, 4, 5)
     */
    WhereBuild notIn(boolean condition, String column, Object... values);

    default WhereBuild and(Consumer<WhereBuild> consumer) {
        return and(true, consumer);
    }

    /**
     * AND 嵌套
     * 例: and(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereBuild and(boolean condition, Consumer<WhereBuild> consumer);

    default WhereBuild or(Consumer<WhereBuild> consumer) {
        return or(true, consumer);
    }

    /**
     * OR 嵌套
     * 例: or(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereBuild or(boolean condition, Consumer<WhereBuild> consumer);

    default WhereBuild or() {
        return or(true);
    }

    /**
     * 拼接 OR
     */
    WhereBuild or(boolean condition);

    default WhereBuild nested(Consumer<WhereBuild> consumer) {
        return nested(true, consumer);
    }

    /**
     * 正常嵌套 不带 AND 或者 OR
     * 例: nested(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereBuild nested(boolean condition, Consumer<WhereBuild> consumer);

    default WhereBuild not(Consumer<WhereBuild> consumer) {
        return not(true, consumer);
    }

    /**
     * not嵌套
     * 例: not(i -> i.eq("name", "李白").ne("status", "活着"))
     */
    WhereBuild not(boolean condition, Consumer<WhereBuild> consumer);

    default WhereBuild applySql(String applySql, Object... values) {
        return applySql(true, applySql, values);
    }

    /**
     * 拼接 sql
     * 会有 sql 注入风险
     * 例1: apply("id = 1")
     * 例2: apply("date_format(dateColumn,'%Y-%m-%d') = '2008-08-08'")
     * 例3: apply("date_format(dateColumn,'%Y-%m-%d') = {0}", LocalDate.now())
     */
    WhereBuild applySql(boolean condition, String applySql, Object... values);
}
