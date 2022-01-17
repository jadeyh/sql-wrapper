package com.yu.wrapper.core.toolkits.sqlToolkits;

import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.utils.SqlScriptUtils;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * sql预编译参数map
 */
public class ParamMap extends HashMap<String, Object> {
    //占位符前缀
    private String placeholderPrefix;

    protected AtomicInteger paramNameSeq = new AtomicInteger();

    public ParamMap(String placeholderPrefix) {
        this.placeholderPrefix = placeholderPrefix;
    }

    /**
     * 设置参数并返回占位符
     */
    public String putAndGetKey(Object param) {
        return putAndGetKey(param, null);
    }

    /**
     * 设置参数并返回占位符
     */
    public String putAndGetKey(Object param, String mapping) {
        String paramName = Constants.PARAM + paramNameSeq.incrementAndGet();
        String paramStr = placeholderPrefix + paramName;
        put(paramName, param);
        return SqlScriptUtils.safeParam(paramStr, mapping);
    }
}
