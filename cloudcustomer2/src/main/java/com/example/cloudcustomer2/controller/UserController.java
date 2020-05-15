package com.example.cloudcustomer2.controller;

import com.example.cloudcustomer2.service.LocalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private LocalService localService;

    @GetMapping("getAll2")
    public List<Map> getAll2() {
        return localService.getAll2();
    }

    @GetMapping("add")
    public int add(@RequestParam Map map){
//        System.out.println("--------customer-------UserController.add");
        return localService.add(map);
    }

    @GetMapping("del")
    public int del(Integer id){
        return localService.del(id);
    }

    @GetMapping("update")
    public int update(@RequestParam Map map) {
        return localService.update(map);
    }
}
