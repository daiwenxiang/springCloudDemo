package com.example.cloudcustomer.service;

import java.util.List;
import java.util.Map;

public interface LocalService {

    List<Map> getAll();

    int add(Map map);

    int del(Integer id);

    int update(Map map);
}
