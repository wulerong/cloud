package com.demo.servicea.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAController {

    // 为了区分负载均衡
    @Value("${server.port}")
    private String port;

    @RequestMapping("/testA")
    public String testA() {
        return "testA" + port;
    }
}