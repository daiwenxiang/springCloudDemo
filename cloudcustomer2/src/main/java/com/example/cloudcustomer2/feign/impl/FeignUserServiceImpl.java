package com.example.cloudcustomer2.feign.impl;

import com.example.cloudcustomer2.feign.FeignUserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FeignUserServiceImpl implements FeignUserService {

    @Override
    public List<Map> getAll2() {
        Map map = new HashMap();
        map.put("status", "备胎数据");
        map.put("msg", "备胎驾到");
        List list = new ArrayList();
        list.add(map);
        return list;
    }

    @Override
    public int add(Map map) {
        return 0;
    }

    @Override
    public int del(Integer id) {
        return 0;
    }

    @Override
    public int update(Map map) {
        return 0;
    }
}
