package com.room.entity.domain.factory;

import java.util.function.Function;

/**
 * @Author: Dong
 * @Description:  属性复制接口，用于自定义属性复制
 * @Date:Created in 21:202019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
public interface PropertyCopier<S, T> {
    T copyProperties(S source,T Target);
}
