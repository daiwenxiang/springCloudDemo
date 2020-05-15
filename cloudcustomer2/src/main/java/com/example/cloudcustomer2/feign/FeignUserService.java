package com.example.cloudcustomer2.feign;

import com.example.cloudcustomer2.feign.impl.FeignUserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "cloudprovider", fallback = FeignUserServiceImpl.class)
//@FeignClient("cloudprovider")
public interface FeignUserService {

    @GetMapping("getAll2")
    List<Map> getAll2();

    @GetMapping("add")
    int add(@RequestParam("map") Map map);

    @GetMapping("del")
    int del(@RequestParam("id") Integer id);

    @GetMapping("update")
    int update(@RequestParam("map") Map map);
}
