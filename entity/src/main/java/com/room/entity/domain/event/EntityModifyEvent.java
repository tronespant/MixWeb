package com.room.entity.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author: Dong
 * @Description: 实体修改事件
 * @Date:Created in 21:122019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@AllArgsConstructor
@Getter
public class EntityModifyEvent<E> implements Serializable {
     private E before;
     private E after;
     private Class<E> entityType;
}
