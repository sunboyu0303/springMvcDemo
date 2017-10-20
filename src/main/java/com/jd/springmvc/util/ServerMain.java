package com.jd.springmvc.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunboyu on 2017/8/2.
 */
public class ServerMain {

    public static void main(String[] args){

        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/jsf-provider.xml");
        System.out.println("服务端启动完成！");

        // 启动本地服务，然后hold住本地服务
        synchronized (ServerMain.class) {
            while (true) {
                try {
                    ServerMain.class.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
