package com.hao.controller;

import com.hao.entity.JdbcProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Value("${helloworld}")
    private String helloWorld;

    @Resource
    private JdbcProperties jdbcProperties;

    @RequestMapping("say")
    public String say() {
        return helloWorld;
    }

    @RequestMapping("showJdbc")
    public String showJdbc() {
        return jdbcProperties.toString();
    }
}
