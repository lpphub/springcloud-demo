package test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.remote.RemoteBookService;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private RemoteBookService bookService;

    @RequestMapping(value = "/{userId}/all", method = RequestMethod.GET)
    public Map<String, Object> query(@PathVariable Integer userId) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());

        Map<String, Object> map = new HashMap<>();
        Map<String, String> user = new HashMap<>();
        user.put("id", String.valueOf(userId));
        user.put("name", "小王");
        map.put("user", user);
        map.put("book", bookService.queryBooks(userId));
        return map;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(String name) {
        return "hello " + name;
    }
}
