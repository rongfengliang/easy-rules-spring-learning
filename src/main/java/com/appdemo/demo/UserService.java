package com.appdemo.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserService {
   static Log log = LogFactory.getLog(UserService.class);

    public static void doAction1(User user){
     log.info("------------do action1------------");
     log.info(user.toString());
    }

    public static void doAction2(User user){
        log.info("------------do action2------------");
        user.setName("sssssssssssssssssss");
        log.info(user.toString());
    }
    public static void doAction3(Map user){
        log.info("------------do action3------------");
        log.info(user.toString());
    }

    public static   void appendName(User user){
        /**
         * 通过静态全局ApplicationConext 获取bean引用
         */
        MyService myService =SpringBeanUtil.getBean(MyService.class);
        myService.setInfo(user);
    }
    public static void doAction4(Object user){
        /**
         * 基于mvel 修改数据，为了复用doAction4,做了数据兼容处理
         */
        if (user instanceof  Map ){
            log.info("------------do action4------------");
            ((Map)user).put("name2","rule do action4");
        }
        if (user instanceof  User) {
            ((User)user).setName("dalong demo appapapappapa");
        }
        log.info(user.toString());
    }
}
