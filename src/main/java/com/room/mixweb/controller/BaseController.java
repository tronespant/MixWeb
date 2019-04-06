package com.room.mixweb.controller;

import com.sun.media.ProcessEngine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 18:10 2019/3/12
 * @Modify by:
 */
@Controller
@RequestMapping(value = "/")
public class BaseController {

    @RequestMapping(value = "/")
    public String home(ModelAndView mv){
        mv.addObject("title","Dong");
     return "/login";
    }
    @RequestMapping(value = "/userLogin")
    public String login(String loginName,String password){
        System.out.println(loginName+password);
        return "/index";
    }
    @RequestMapping(value ="activiti_model" )
    public String getAcModel(){
        return "form/activiti_model";
    }

}
