package com.room.entity.domain.factory;

/**
 * @Author: Dong
 * @Description:  实体工厂接口，系统各个地方使用此接口来创建实体
 * 在实际编码中也应该使用此接口来创建接口 而不是使用new 方式来创建
 * @Date:Created in 21:222019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
public interface EntityFactory {
    /**
     * 根据类型常见实例
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> T newInstance(Class<T> entityClass);

    /**
     * 根据类型创建实例，如果类型无法创建 则使用默认的类型创建
     * @param entityClass
     * @param defaultClass
     * @param <T>
     * @return
     */
    <T> T newInstance(Class<T> entityClass,Class<? extends T> defaultClass);

    /**
     * 创建实体并设置默认属性
     * @param entityClass 实体类型
     * @param defaultProperties 默认属性
     * @param <S> 默认属性类型
     * @param <T>
     * @return
     */
    default <S, T> T newInstance(Class<T> entityClass, S defaultProperties) {
        //TODO
        return copyProperties(defaultProperties,newInstance(entityClass));
    }
    default <S, T> T newInstance(Class<T> entityClass, Class<? extends T> defautlClass, S defaultProperties) {
        //TODO
        return copyProperties(defaultProperties,newInstance(entityClass,defautlClass));
    }

    /**
     * 根据类型获取尸体的真实的实体类型
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> Class<T> getInstanceType(Class<T> entityClass);

    /**
     * 拷贝对象属性
     * @param source
     * @param target
     * @param <S>
     * @param <T>
     * @return
     */
    <S,T> T copyProperties(S source,T target);
}

