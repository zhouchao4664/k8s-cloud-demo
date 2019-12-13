package com.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2019/11/28 20:18
 * @Description
 **/
@Slf4j
@RestController
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("service")
    public String user(){
        List<ServiceInstance> services = discoveryClient.getInstances("order");
        if (services.size()>0){
            services.forEach(i->{
                URI uri = i.getUri();
                System.out.println(uri.getPath());
                System.out.println(uri.toString());
                connection(uri.toString());
            });
        }else {
            return "没有获得服务";
        }
        return "获得了服务";
    }

    private void connection(String service){
        URL url;
        try {
            url = new URL(service);
            URLConnection co = url.openConnection();
            co.connect();
            System.out.println("连接可用");
        } catch (Exception e) {
            System.out.println("连接不可用");
        }
    }

}
