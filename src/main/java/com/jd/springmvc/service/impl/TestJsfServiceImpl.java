package com.jd.springmvc.service.impl;

import com.jd.springmvc.service.TestJsfService;

/**
 * Created by sunboyu on 2017/8/2.
 */
public class TestJsfServiceImpl implements TestJsfService {

    public String getMessage(String s) {
        System.out.println("server get request :" + s);
        return s;
    }
}
