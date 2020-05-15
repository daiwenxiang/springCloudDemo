package com.example.cloudcustomer2.service.impl;

import com.example.cloudcustomer2.feign.FeignUserService;
import com.example.cloudcustomer2.service.LocalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LocalServiceImpl implements LocalService {

    @Resource
    private FeignUserService feignUserService;

    @Override
    public List<Map> getAll2() {
        return feignUserService.getAll2();
    }

    @Override
    public int add(Map map) {
//        System.out.println("------customer---------LocalServiceImpl.add");
        return feignUserService.add(map);
    }

    @Override
    public int del(Integer id) {
        return feignUserService.del(id);
    }

    @Override
    public int update(Map map) {
        return feignUserService.update(map);
    }


}
