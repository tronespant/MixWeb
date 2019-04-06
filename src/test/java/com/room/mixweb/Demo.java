package com.room.mixweb;

import com.room.mixweb.Annotation.DemoConfig;
import com.room.mixweb.Annotation.DemoService;
import com.room.mixweb.condition.ConfigureforCondition;
import com.room.mixweb.scheduler.SchedulerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:202019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(
                DemoConfig.class
        );
        DemoService service = context.getBean(DemoService.class);
        service.outputResult();
        context.close();
    }
}
