package com.example.cloudcustomer.controller;

import com.example.cloudcustomer.service.LocalService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private LocalService localService;

    @GetMapping("getAll")
    public List<Map> getAll() {
        return localService.getAll();
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
