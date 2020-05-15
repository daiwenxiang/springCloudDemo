package com.example.cloudprovider.service.impl;

import com.example.cloudprovider.mapper.UserMapper;
import com.example.cloudprovider.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<Map> getAll() {
        return userMapper.getAll();
    }

    @Override
    public int add(Map map) {
//        System.out.println("------------provider--------UserServiceImpl.add");
        return userMapper.add(map);
    }

    @Override
    public int del(Integer id) {
        return userMapper.del(id);
    }

    @Override
    public int update(Map map) {
        return userMapper.update(map);
    }
}
