package com.yu.wrapper.core;

public interface UpdateBuild<ImplClass> {
    default ImplClass update(String column, Object val) {
        return update(true, column, val);
    }

    default ImplClass update(boolean condition, String column, Object val) {
        return update(condition, column, val, null);
    }

    default ImplClass update(String column, Object val, String mapping) {
        return update(true, column, val, mapping);
    }

    /**
     * 更新字段
     */
    ImplClass update(boolean condition, String column, Object val, String mapping);

    /**
     * 更新内容SQL片段
     */
    String getUpdateSegment();
}
