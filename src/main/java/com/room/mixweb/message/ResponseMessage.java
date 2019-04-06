package com.room.mixweb.message;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author:dong
 * @Despriction:相应信息，controller处理后，返回此对象，响应请求给客户端
 * @Date:my Create in 17:30 2019/3/21
 * @Modify by:
 */
public class ResponseMessage<T> implements Serializable {

    /**
     * 调用结果消息
     */
    protected String message;
    /**
     * 成功响应数据
     */
    protected T result;
    /**
     * 状态码
     */
    protected int status;
    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 业务代码
     */
    private String code;

    public String getMessage() {
        return message;
    }

    public T getResult() {
        return result;
    }
    public int getStatus() {
        return status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static <T> ResponseMessage<T> error(String message){
        return error(500,message);
    }
    public static <T> ResponseMessage<T> error(int status,String message){
        ResponseMessage<T> msg=new ResponseMessage<>();
        msg.message=message;
        msg.status(status);
        return msg.putTimeStamp();
    }

    public ResponseMessage<T> putTimeStamp() {
        this.timestamp=System.currentTimeMillis();
        return this;
    }
    public static <T> ResponseMessage<T> ok(){
        return ok(null);
    }
    private static <T> ResponseMessage<T> ok(T result){
        return new ResponseMessage<T>().result(result).putTimeStamp().status(200);
    }

    public  ResponseMessage<T> result(T result) {
        this.result=result;
        return this;
    }

    public ResponseMessage<T> status(int status){
        this.status=status;
        return this;
    }
    public ResponseMessage<T> code(int status){
        this.code=code;
        return this;
    }
    /**
     * 过滤字段：指定需要序列化的字段
     */
    private transient Map<Class<?>, Set<String>> includes;
    /**
     * 过滤字段：指定需要序列化的字段
     */
    private transient Map<Class<?>, Set<String>> excludes;

    /**
     *
     * @// TODO: 2019/3/21
     * @param type
     * @param fields 格式未定
     * @return
     */

    public ResponseMessage<T> include(Class<?> type, Collection<String> fields) {
        if (includes==null){
            includes=new HashMap<>();
        }
        if (fields==null || fields.isEmpty()){
            return this;
        }
        fields.forEach(field ->{
            if (field.contains(".")){
              String tmp[]=field.split("[.]",2);
              try {
                  Field field1 = type.getDeclaredField(tmp[1]);
                  if (field1!=null){
                      include(field1.getType(),tmp[1]);
                  }
              }catch (Exception ignore){

              }
            }else{
                getStringListFormMap(includes,type).add(field);
            }
        });
        return this;
    }
    public ResponseMessage<T> exclude(Class<?> type, Collection<String> fields) {
        if (includes==null){
            includes=new HashMap<>();
        }
        if (fields==null || fields.isEmpty()){
            return this;
        }
        fields.forEach(field ->{
            if (field.contains(".")){
                String tmp[]=field.split("[.]",2);
                try {
                    Field field1 = type.getDeclaredField(tmp[0]);
                    if (field1!=null){
                        include(field1.getType(),tmp[1]);
                    }
                }catch (Exception ignore){

                }
            }else{
                getStringListFormMap(excludes,type).add(field);
            }
        });
        return this;
    }
    private Set<String> getStringListFormMap(Map<Class<?>, Set<String>> map, Class<?> type) {
          return map.computeIfAbsent(type,k ->new HashSet<>());
    }
    public ResponseMessage<T> exclude(Collection<String> fields){
        if (excludes==null){
            excludes=new HashMap<>();
        }
        if (fields==null||fields.isEmpty()){
            return this;
        }
        Class type;
        if (getResult()!=null){
            type=getResult().getClass();
        }else{
            return this;
        }
        exclude(type,fields);
        return this;
    }
    public ResponseMessage<T> include(Collection<String> fields){
        if (includes==null){
            includes=new HashMap<>();
        }
        if (fields==null||fields.isEmpty()){
            return this;
        }
        Class type;
        if (getResult()!=null){
            type=getResult().getClass();
        }else{
            return this;
        }
        include(type,fields);
        return this;
    }
    public ResponseMessage<T> exclude(Class type,String... fields){
        return exclude(type,(Arrays.asList(fields)));
    }
    public ResponseMessage<T> exclude(String... fields){
        return exclude((Arrays.asList(fields)));
    }
    public ResponseMessage<T> include(Class type,String... fields){
        return include(type,(Arrays.asList(fields)));
    }
    public ResponseMessage<T> include(String... fields){
        return include((Arrays.asList(fields)));
    }

    public Map<Class<?>, Set<String>> getIncludes() {
        return includes;
    }

    public Map<Class<?>, Set<String>> getExcludes() {
        return excludes;
    }

    @Override
    public String toString() {
        return JSON.toJSONStringWithDateFormat(this,"yyyy-MM-dd HH:mm:ss");
    }
}
