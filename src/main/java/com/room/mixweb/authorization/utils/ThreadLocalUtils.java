package com.room.mixweb.authorization.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author:dong
 * @Despriction: ThreadLocal工具类，通过在ThradLocal存储map信息，来实现在ThreadLocal中维护多个信息
 *  * <br>e.g.<code>
 *  * ThreadLocalUtils.put("key",value);<br>
 *  * ThreadLocalUtils.get("key");<br>
 *  * ThreadLocalUtils.remove("key");<br>
 *  * ThreadLocalUtils.getAndRemove("key");<br>
 *  * ThreadLocalUtils.get("key",()-&gt;defaultValue);<br>
 *  * ThreadLocalUtils.clear();<br>
 *  * </code>
 * @Date:my Create in 16:43 2019/3/19
 * @Modify by:
 * @since 2.0
 */
public class ThreadLocalUtils<T> {
    private static final ThreadLocal<Map<String,Object>> threadLocal=ThreadLocal.withInitial(HashMap::new);
    public ThreadLocalUtils() {
    }

    /**
     * 获取 thread中所有值
     * @return
     */
    public static Map<String,Object> getAll(){
        return threadLocal.get();
    }

    /**
     * 设置一个值到ThreadLocal
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public static <T> T put(String key,T value){
        threadLocal.get().put(key,value);
        return value;
    }

    /**
     * 删除一个指定参数的值
     * @param key
     */
    public static void remove(String key){
        threadLocal.get().remove(key);
    }

    /**
     * 清空ThreadLoal
     */
    public static void clear(){
        threadLocal.remove();
    }

    /**
     * 获取一个指定的值 在ThreadLocal
     * @param key 键
     * @param <T> 值
     * @return
     *
     */
    public static<T> T get(String key){
        return ((T) threadLocal.get().get(key));
    }

    /**
     * 从ThreadLocal中获取值 并指定一个当值不存在的提供者
     * @param key
     * @param supplierOnNull
     * @param <T>
     * @return
     * @see Supplier
     */
    public static<T> T get(String key, Supplier<T> supplierOnNull){
        return (T) threadLocal.get().computeIfAbsent(key, k -> supplierOnNull.get());
    }
    /**
     * 获取一个指定的值然后删除
     * @param key 键
     * @param <T> 值类型
     * @return 值 不存在则放回null
     * @see this#get(String)
     * @see this#remove(String)
     */
    public static<T> T getAndRemove(String key){
        try{
            return get(key);
        }finally {
            remove(key);
        }
    }
}
