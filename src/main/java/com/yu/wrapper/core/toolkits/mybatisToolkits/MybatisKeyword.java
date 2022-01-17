package com.yu.wrapper.core.toolkits.mybatisToolkits;

public interface MybatisKeyword {
    /**
     * 安全的占位符左边部分
     */
    String SAFE_PLACEHOLDER_LEFT = "#{";

    /**
     * 不安全的占位符左边部分
     */
    String UNSAFE_PLACEHOLDER_LEFT = "${";

    /**
     * 占位符右边部分
     */
    String PLACEHOLDER_RIGHT = "}";

    /**
     * 百分号 like用
     */
    String PERCENT = "%";
}
