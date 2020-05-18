package com.example.cloudprovider.controller;

import com.example.cloudprovider.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService userService;

//    @GetMapping("getAll")
//    public List<Map> getAll() {
//        return userService.getAll();
//    }

    @GetMapping("/getAll")
    public List<Map> getAll() {
//        try {
//            System.out.println("1111111");
//            Thread.sleep(2000);
//            System.out.println("2222222");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.getAll();
    }

    @GetMapping("/getAll2")
    public List<Map> getAll2() {
        try {
            System.out.println("1111111");
            Thread.sleep(2000);
            System.out.println("2222222");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userService.getAll();
    }

    @GetMapping("/add")
    public int add(@RequestParam Map map){
        System.out.println("-----provider-------UserController.add");
        return userService.add(map);
    }

    @GetMapping("/del")
    public int del(Integer id){
        return userService.del(id);
    }

    @GetMapping("/update")
    public int update(@RequestParam Map map) {
        return userService.update(map);
    }
}
