package com.yu.wrapper.core;

public interface UpdateBuild<ImplClass> {
    /**
     * 更新字段
     */
    ImplClass update(String... columns);

    /**
     * 更新内容SQL片段
     */
    String getSqlUpdate();
}
