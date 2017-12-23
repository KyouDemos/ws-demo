package com.example.demo.controller;


import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * File Header
 * PROJECT_NAME: ws-demo
 * PACKAGE_NAME: com.example.demo.controller
 *
 * @author wangqiang
 * @date 2017/12/21 19:12
 */
@RestController
public class DemoController {

    /**
     * 无参接口
     *
     * @return Result
     */
    @RequestMapping("/demo")
    public String doSearch() {
        return "No Param Interface.";
    }


    /**
     * 基本类型参数 - 普通参数形式
     *
     * @param name 用户名
     * @return User
     */
    @RequestMapping(value = "/getUser1")
    public User getUser1(@RequestParam("name") String name) {
        return getUserByName(name);
    }

    /**
     * 基本类型参数 - 路由参数形式
     *
     * @param name 用户名
     * @return User
     */
    @RequestMapping("/getUser2/{name}")
    public User getUser2(@PathVariable("name") String name) {
        return getUserByName(name);
    }

    /**
     * 自定义类型参数 - 普通参数形式
     *
     * @param user user
     * @return user
     */
    @RequestMapping(value = "/getUser3", method = RequestMethod.POST)
    public User getUser3(@RequestBody User user) {
        return user;
    }

    /**
     * 复合型参数
     *
     * @param age  age
     * @param user user
     * @return return
     */
    @RequestMapping("getUser4")
    public User getUser4(@RequestParam("age") int age, @RequestBody User user) {
        user.setAge(age);
        return user;
    }

    @RequestMapping("getYoungUser")
    public User getYoungUser(@RequestBody User... users) {
        System.out.println("users.length: " + users.length);
        User youngUser = new User();

        for (User user : users) {
            if (youngUser.getAge() == 0) {
                youngUser = user;
            } else if (user.getAge() < youngUser.getAge()) {
                youngUser = user;
            }
        }

        return youngUser;
    }

    private User getUserByName(String name) {
        User user = new User();

        String a = "a";
        if (a.equals(name)) {
            user.setAge(10);
            user.setName("A");
        } else {
            user.setName("B");
            user.setAge(20);
        }
        return user;
    }
}
