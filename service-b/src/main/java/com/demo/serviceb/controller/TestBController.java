package com.demo.serviceb.controller;

import com.demo.serviceb.service.ServiceAFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestBController {

    @Autowired
    private ServiceAFeignClient serviceAFeignClient;
    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("call")
    public String call(){
        String result = serviceAFeignClient.TestAController();
        return port+"b to a 访问结果 ---" + result;
    }

    @RequestMapping("test")
    public String test(){
        String url = "http://SERVICE-OBJCAT-A/testA";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return port+"b to a 访问结果 ---" + forEntity.getBody();
    }

    @RequestMapping("testb")
    public String testb(){
        String url = "http://SERVICE-OBJCAT-B/test";
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();
    }
}