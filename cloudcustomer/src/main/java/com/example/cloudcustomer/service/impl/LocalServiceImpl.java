package com.example.cloudcustomer.service.impl;

import com.example.cloudcustomer.feign.FeignUserService;
import com.example.cloudcustomer.service.LocalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LocalServiceImpl implements LocalService {

    @Resource
    private FeignUserService feignUserService;

    @Override
    public List<Map> getAll() {
        return feignUserService.getAll();
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
