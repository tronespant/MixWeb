package com.room.mixweb.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:272019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        return conditionContext.getEnvironment().getProperty("os.name").contains("windows");
    }
}
