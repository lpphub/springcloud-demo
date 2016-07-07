package com.lsk.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BookService {
    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Value("${test.message}")
    private String message;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public Map<String, Object> query(@RequestParam Integer userId) {
        logger.info("userId:{} query book...", userId);
        Map<String, Object> map = new HashMap<>();
        map.put("java", "01");
        map.put("c", "02");
        map.put("python", "03");
        map.put("php", "04");
        map.put("config", message);
        return map;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable String id) {
        if ("01".equals(id)) {
            return "java";
        }
        if ("03".equals(id)) {
            return "python";
        }
        return "hello " + message;
    }
}
