package com.room.mixweb.authorization.manager;

import com.room.mixweb.domain.Permission;
import com.room.mixweb.domain.Role;
import com.room.mixweb.domain.User;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.List;

/**
 * @Author:dong
 * @Despriction:
 *  用户授权信息, 当前登录用户的权限信息, 包括用户的基本信息, 角色, 权限集合等常用信息<br>
 *  * 获取方式:
 *  * <ul>
 *  * <li>springmvc 入参方式: ResponseMessage myTest(Authorization auth){}</li>
 *  * <li>静态方法方式:AuthorizationHolder.get();</li>
 *  * </ul>
 * @Date:my Create in 15:26 2019/3/19
 * @Modify by:
 */
public interface Authentication extends Serializable {

    /**
     *返回Authentication对象
     * @return 返回Optional对象进行操作
     * @See Optional
     * @see AuthenticationHolder
     */
    static Optional<Authentication> current(){
        return Optional.ofNullable(AuthenticationHolder.get());
    }

    /**
     * @return 用户信息
     */
    User getUser();

    /**
     * @return 返回用户持有的角色集合
     */
    List<Role> getRoles();

    /**
     * @return 用户持有的权限集合
     */
    List<Permission> getPermission();
    /**
     * @param id 角色id
     * @return 角色信息
     */
    default Optional<Role> getRole(String id){
        if (null==id){
            return  Optional.empty();
        }
        return getRoles().stream()
                .filter(role -> role.getId().equals(id))
                .findAny();
    }

    /**
     *
     * @param id
     * @return Optional<permission> 权限信息</>
     */
    default Optional<Permission> getPermission(String id){
        if (null==id){
            return  Optional.empty();
        }
        return getPermission().stream()
                .filter(permission -> permission.getId().equals(id))
                .findAny();
    }

    /**
     * 判断是否持有某权限以及对权限的可操作事件
     * @param permissionId
     * @param actions
     * @return 是否持有权限
     */
    default boolean hasPermission(String permissionId,String... actions){
        return getPermission(permissionId)
                .filter(permission -> actions.length==0||permission.getActions().containsAll(Arrays.asList(actions)))
                .isPresent();
    }

    /**
     *
     * @param roleId
     * @return 是否拥有某个角色
     */
    default boolean hasRole(String roleId){
        return getRole(roleId).isPresent();
    }
    /**
     * 根据属性名获取属性值，返回一个{@link Optional} 对象
     * 此方法可用于获取自定义的属性信息
     * @param name 属性名
     * @param <T> 属性值类型
     * @return Optional属性值
     */
    <T extends Serializable> Optional<T> getAttribute(String name);

    /**
     * 设置一个属性值，如果属性名已存在，则将其覆盖
     * 注意 由于权限信息可能会被序列化，属性必须实现{@link Serializable}接口
     * @param name 属性名称
     * @param object 属性值
     */
    void setAttribute(String name,Serializable object);

    /**
     * 设置多个属性值 参数为map类型 key属性名称，value为属性值
     * @param attributes 属性值map
     * @see AuthenticationManager#sync(Authentication)
     */
    void setAttribute(Map<String,Serializable>  attributes);

    /**
     * 删除属性并返回被删除的值
     * @param name 属性名
     * @param <T> 被删除的值的类型
     * @return 被删除的值
     */
    <T extends Serializable> T removeAttributes(String name);

    /**
     * 获取全部属性，此属性为通过{@link this#setAttribute(String, Serializable)}或{@link this#setAttribute(Map)}设置的属性
     * @return 全部属性集合
     */
    Map<String,Serializable> getAttributes();

}
