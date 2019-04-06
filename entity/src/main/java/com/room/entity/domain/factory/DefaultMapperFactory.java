package com.room.entity.domain.factory;

import java.util.function.Function;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:162019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@FunctionalInterface
public interface DefaultMapperFactory extends Function<Class,String> {
}
