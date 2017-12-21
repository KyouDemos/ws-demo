package com.example.demo.Client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * File Header
 * PROJECT_NAME: ws-demo
 * PACKAGE_NAME: com.example.demo.Client
 * Created by wangqiang on 2017/12/21 20:40.
 */
public class Call {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/demo";

        // 无参数接口
        String rst = restTemplate.getForObject(url,String.class);
        System.out.println(rst);


        // 单个参数接口
        url = "http://localhost:8080/getYoungUser";

//        restTemplate.exchange(url, HttpMethod.GET,)
    }
}
