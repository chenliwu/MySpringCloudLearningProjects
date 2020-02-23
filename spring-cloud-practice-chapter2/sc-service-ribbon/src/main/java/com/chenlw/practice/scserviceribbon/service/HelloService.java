package com.chenlw.practice.scserviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenlw
 * @date 2020/02/23
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        // SERVICE-HI是sc-service-hi工程的name，服务名为SERVICE-HI ,端口为7862
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

}
