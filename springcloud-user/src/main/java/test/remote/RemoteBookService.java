package test.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import test.hystrix.BookServiceFallback;

import java.util.Map;

@FeignClient(value = "book-service", fallback = BookServiceFallback.class)
public interface RemoteBookService {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    Map<String, Object> queryBooks(@RequestParam(value = "userId") Integer userId);
}
