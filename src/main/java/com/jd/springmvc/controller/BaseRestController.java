package com.jd.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseRestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("123123");
        return "aa";
    }
}
