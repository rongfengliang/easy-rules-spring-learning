package com.appdemo.demo;

import org.springframework.stereotype.Component;

/**
 * @author  dalonng
 *
 * mybean for ref
 */
@Component
public class MyService {

    public  void setInfo(User user){
        user.setName("rongfengliang");
    }
}
