package com.room.entity.domain.bean;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:472019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
public interface BeanFactory {

    <T> T newInstance(Class<T> beanType);
}
