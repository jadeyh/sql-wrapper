package com.yu.wrapper.core.toolkits;

/**
 * 常量
 */
public interface Constants {
    /**
     * 点
     */
    String DOT = ".";

    /**
     * sql封装类的默认参数名
     */
    String WRAPPER = "sw";

    /**
     * sql封装类的参数map的参数名
     */
    String PARAM_MAP = "paramMap";

    /**
     * sql封装类的参数map的key值前缀
     */
    String PARAM = "param";

    String DEFAULT_PLACEHOLDER_PREFIX = WRAPPER + DOT + PARAM_MAP + DOT;

    String COMMA = ",";

    String LEFT_BRACKET = "(";

    String RIGHT_BRACKET = ")";

    String LEFT_BRACE = "{";

    String RIGHT_BRACE = "}";

    String SPACE = " ";

    String EMPTY = "";

    String WHERE = "WHERE";
}
