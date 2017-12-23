package com.example.demo.Client;

import com.example.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * File Header
 * PROJECT_NAME: ws-demo
 * PACKAGE_NAME: com.example.demo.Client
 * Created by wangqiang on 2017/12/21 20:40.
 */
public class CallRestFullInterface {
    private static final Logger _log = LoggerFactory.getLogger(CallRestFullInterface.class);

    public static void main(String[] args) {

        User user;
        RestTemplate restTemplate = new RestTemplate();

        String rst = restTemplate.getForObject(getUrl("/demo"), String.class);
        _log.info("调用无参接口，返回字符串：{}", rst);

        _log.info("=======================================调用普通参数接口");
        // 调用普通参数接口(方法一)
        user = restTemplate.getForObject(getUrl("/getUser1?name=B"), User.class);
        _log.info("调用普通参数接口(方法一) - 1，返回User对象：{}", user);

        user = restTemplate.getForObject(getUrl("/getUser1?name={name}"), User.class, "B");
        _log.info("调用普通参数接口(方法一) - 2，返回User对象：{}", user);

        // 调用普通参数接口(方法二)
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("name", "a");
        user = restTemplate.postForObject(getUrl("/getUser1"), dataMap, User.class);
        _log.info("调用普通参数接口(方法二)，返回User对象：{}", user);


        _log.info("=======================================调用路由参数接口");
        // 调用路由参数接口
        user = restTemplate.getForObject(getUrl("/getUser2/a"), User.class);
        _log.info("调用路由参数接口 - 1，返回User对象：{}", user);

        user = restTemplate.getForObject(getUrl("/getUser2/{name}"), User.class, "a");
        _log.info("调用路由参数接口 - 2，返回User对象：{}", user);


        _log.info("=======================================调用自定义类型参数接口");
        // 调用自定义类型参数接口
        user.setAge(30);
        user.setName("C");
        user = restTemplate.postForObject(getUrl("/getUser3"), user, User.class);
        _log.info("调用自定义参数接口 - 1，返回User对象：{}", user);

        HttpEntity<User> requestEntity = new HttpEntity<>(user);
        ResponseEntity<User> responseEntity = restTemplate.exchange(getUrl("/getUser3"), HttpMethod.POST, requestEntity, User.class);
        _log.info("调用自定义参数接口 - 2，返回User对象：{}", responseEntity.getBody());


        _log.info("=======================================调用复合参数接口");
        // 调用复合参数接口
        user = restTemplate.postForObject(getUrl("/getUser4?age={age}"), user, User.class, 60);
        _log.info("调用复合参数接口 - 1，返回User对象：{}", user);


        List<User> userList = new ArrayList<>();
        User user1 = new User("user1", 10);
        userList.add(user1);
        User user2 = new User("user2", 20);
        userList.add(user2);

        HttpEntity<List<User>> requestEntity1 = new HttpEntity<>(userList);
        responseEntity = restTemplate.exchange(getUrl("/getYoungUser"), HttpMethod.POST, requestEntity1, User.class);
        _log.info("调用复合参数接口 - 2，返回User对象：{}", responseEntity.getBody());

        user = restTemplate.postForObject(getUrl("/getYoungUser"), userList, User.class);
        _log.info("调用复合参数接口 - 3，返回User对象：{}", user);

    }

    private static String getUrl(String routing) {
        return "http://localhost:8080" + routing;
    }
}
