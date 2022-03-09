package com.yu.wrapper.core;

public interface UpdateBuild<ImplClass> {
    /**
     * 更新字段
     */
    ImplClass update(boolean condition, String column, Object val, String mapping);

    /**
     * 更新内容SQL片段
     */
    String getUpdateSegment();
}
