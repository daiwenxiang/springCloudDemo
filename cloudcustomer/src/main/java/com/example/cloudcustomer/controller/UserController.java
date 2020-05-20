package com.example.cloudcustomer.controller;

import com.example.cloudcustomer.service.LocalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private LocalService localService;

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("list", localService.getAll());
        return modelAndView;
    }

    @GetMapping("/getAll")
    public List<Map> getAll(String words) {
        System.out.println("words = " + words);
        return localService.getAll();
    }

    @GetMapping("/add")
    public int add(@RequestParam Map map){
//        System.out.println("--------customer-------UserController.add");
        return localService.add(map);
    }

    @GetMapping("/del")
    public int del(Integer id){
        return localService.del(id);
    }

    @GetMapping("/update")
    public int update(@RequestParam Map map) {
        return localService.update(map);
    }
}
