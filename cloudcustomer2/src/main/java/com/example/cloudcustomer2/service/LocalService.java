package com.example.cloudcustomer2.service;

import java.util.List;
import java.util.Map;

public interface LocalService {

    List<Map> getAll2();

    int add(Map map);

    int del(Integer id);

    int update(Map map);
}
