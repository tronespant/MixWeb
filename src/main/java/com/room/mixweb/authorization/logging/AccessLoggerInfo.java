package com.room.mixweb.authorization.logging;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 15:09 2019/3/19
 * @Modify by:
 */
@Data
public class AccessLoggerInfo {
    /**
     * 日志id
     */
    private String id;
    private String action;
    private String describe;
    private Method method;
    private Class target;
    private Map<String,Object> parameters;
    private String ip;
    private String url;
    private Map<String,String> httpHeader;
    private String httpMethod;
    private Object response;
    private long requestTime;
    private long responseTime;
    private Throwable exception;

}
