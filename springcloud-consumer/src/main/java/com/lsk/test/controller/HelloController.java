package com.lsk.test.controller;

import com.lsk.test.remote.BaiduService;
import com.lsk.test.remote.HelloServiceClient;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private HelloServiceClient client;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {

        BaiduService baiduService = Feign.builder().target(BaiduService.class, "http://www.baidu.com");
        String index = baiduService.index();
        System.out.println(index);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://www.baidu.com", String.class);
        System.out.println(responseEntity.getBody());

        return client.add(10, 20) + index;
    }

}
