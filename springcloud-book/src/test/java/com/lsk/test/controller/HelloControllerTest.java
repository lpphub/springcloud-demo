package com.lsk.test.controller;

import org.junit.Test;

public class HelloControllerTest {

    @Test
    public void testAdd() throws Exception {
        // feign的调用方式
//        BaiduService baiduService = Feign.builder().target(BaiduService.class, "http://www.baidu.com");
//        String index = baiduService.index();
//        System.out.println(index);

        // 使用spring web的restTemplate访问
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://www.baidu.com", String.class);
//        System.out.println(responseEntity.getBody());
    }

    @Test
    public void testPrint() throws Exception {

    }
}