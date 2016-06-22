package com.lsk.test.controller;

import com.lsk.test.remote.RemoteHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${test.message}")
    private String message;

    @Autowired
    private RemoteHelloService client;

      @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {

        // feign的调用方式
//        BaiduService baiduService = Feign.builder().target(BaiduService.class, "http://www.baidu.com");
//        String index = baiduService.index();
//        System.out.println(index);

        // 使用spring web的restTemplate访问
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://www.baidu.com", String.class);
//        System.out.println(responseEntity.getBody());
        return client.add(10, 20).toString();
    }

    @RequestMapping("/test")
    public String print() {
        return message;
    }

}
