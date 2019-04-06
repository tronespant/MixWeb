package com.room.mixweb.Annotation;

import org.springframework.stereotype.Service;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:512019/4/2
 * @Modificd By:
 * @At : MixWeb
 */
@Service
public class DemoService {
   public void outputResult(){
       System.out.println("从组合注解配置照样活的bean");
   }
}
