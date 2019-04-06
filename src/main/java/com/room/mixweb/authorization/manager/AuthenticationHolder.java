package com.room.mixweb.authorization.manager;

import com.room.mixweb.authorization.utils.ThreadLocalUtils;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;

/**
 * @Author:dong
 * @Despriction: 权限获取器，用于静态方式获取当前登录用户的权限信息
 * <pre>
 *  *     &#064;RequestMapping("/example")
 *  *     public ResponseMessage example(){
 *  *         Authorization auth = AuthorizationHolder.get();
 *  *         return ResponseMessage.ok();
 *  *     }
 * @Date:my Create in 15:31 2019/3/19
 * @Modify by:
 */
public class AuthenticationHolder {
    private static final java.util.List<AuthenticationSupplier> suppliers=new ArrayList();
    private static final String CURRENT_USER_ID_KEY=Authentication.class.getName()+"_current_id";
    private static final ReadWriteLock lock=new ReentrantReadWriteLock();

    public static Authentication get(Function<AuthenticationSupplier,Authentication> function) {
       lock.readLock().lock();
       try{
        return suppliers.stream()
                .map(function)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }finally {
           lock.readLock().unlock();
       }
       }

    /**
     * 当前登录用户的全向信息
     * @return
     */
    public static Authentication get(){
        String currentId= ThreadLocalUtils.get(CURRENT_USER_ID_KEY);
        if (currentId!=null){
            return get(currentId);
        }
        return get(AuthenticationSupplier :: get);
       }
    /**
     *获取指定用户的权限信息
     * @param userId 用户ID
     * @return 权限信息
     */
    public static Authentication get(String userId){
       return get(suppliers -> suppliers.get(userId));
    }

    /**
     * 初始化{@link AuthenticationSupplier}
     * @param supplier
     */
    public static void addSupplier(AuthenticationSupplier supplier){
        lock.writeLock().lock();
        try {
            suppliers.add(supplier);
        }finally {
            lock.writeLock().unlock();
        }
    }
    public static void setCurrentUserId(String id){
        ThreadLocalUtils.put(AuthenticationHolder.CURRENT_USER_ID_KEY,id);
    }
}
