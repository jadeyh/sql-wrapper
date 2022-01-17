package com.yu.wrapper.core.toolkits.sqlToolkits;

import com.yu.wrapper.core.toolkits.Constants;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * sql预编译参数map
 */
public class ParamMap {
    protected Map<String, Object> map = new HashMap<>();
    protected AtomicInteger paramNameSeq;

    public Object get(String key) {
        return null;
    }

    /**
     * 设置参数并返回占位符
     */
    public String putAndGetKey(Object val) {
        String genParamName = Constants.PARAM_MAP + paramNameSeq.incrementAndGet();
//        String paramStr = Constants.WRAPPER_PARAM_MIDDLE + genParamName;
//        paramNameValuePairs.put(genParamName, param);
//        return SqlScriptUtils.safeParam(paramStr, mapping);
        return null;
    }
}
