package com.lsk.test.remote;

import feign.RequestLine;

public interface BaiduService {
    @RequestLine("GET /index.html")
    String index();
}
