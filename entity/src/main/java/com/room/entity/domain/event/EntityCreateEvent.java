package com.room.entity.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Dong
 * @Description: 实体创建事件
 * @Date:Created in 21:082019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@AllArgsConstructor
@Getter
@Setter
public class EntityCreateEvent<E> implements Serializable {

    private E entity;
    private Class<E> entityType;
}
