package com.example.demo.controller;


import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File Header
 * PROJECT_NAME: ws-demo
 * PACKAGE_NAME: com.example.demo.controller
 * Created by wangqiang on 2017/12/21 19:12.
 */
@RestController
public class DemoController {

    @RequestMapping("/demo")
    public String doSearch(){
        return "11111111";
    }

    @RequestMapping("/getYoungUser")
    public User getYoungUser(User... users){

        User youngUser = null;
        for (User user : users) {
            if (youngUser.getAge()>user.getAge())
                youngUser = user;
        }

        return youngUser;
    }
}
