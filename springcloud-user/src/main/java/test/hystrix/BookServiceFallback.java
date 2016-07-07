package test.hystrix;

import org.springframework.stereotype.Component;
import test.remote.RemoteBookService;

import java.util.HashMap;
import java.util.Map;

@Component
public class BookServiceFallback implements RemoteBookService {
    @Override
    public Map<String, Object> queryBooks(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("fallback", "容错处理");
        return map;
    }
}
