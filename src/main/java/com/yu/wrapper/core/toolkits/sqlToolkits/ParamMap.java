package com.yu.wrapper.core.toolkits.sqlToolkits;

import com.yu.wrapper.core.toolkits.Constants;
import com.yu.wrapper.core.toolkits.utils.SqlScriptUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * sql预编译参数map
 */
public class ParamMap {
    //占位符前缀
    private String placeholderPrefix;

    protected Map<String, Object> map = new HashMap<>();
    protected AtomicInteger paramNameSeq = new AtomicInteger();

    public ParamMap(String placeholderPrefix) {
        this.placeholderPrefix = placeholderPrefix;
    }

    public Object get(String key) {
        return null;
    }

    /**
     * 设置参数并返回占位符
     */
    public String putAndGetKey(Object param) {
        String paramName = Constants.PARAM + paramNameSeq.incrementAndGet();
        String paramStr = placeholderPrefix + paramName;
        map.put(paramName, param);
        return SqlScriptUtils.safeParam(paramStr, mapping);
    }
}
