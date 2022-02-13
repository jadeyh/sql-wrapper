package com.yu.wrapper.core;

public interface SelectBuild<ImplClass> {
    /**
     * 查询字段
     */
    ImplClass select(String... columns);

    /**
     * 查询内容SQL片段
     */
    String getSqlSelect();
}
