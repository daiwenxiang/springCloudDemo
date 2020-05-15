package com.example.cloudprovider.service;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Map> getAll();

    int add(Map map);

    int del(Integer id);

    int update(Map map);
}
