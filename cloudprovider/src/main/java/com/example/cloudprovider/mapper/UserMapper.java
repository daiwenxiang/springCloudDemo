package com.example.cloudprovider.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user_info")
    List<Map> getAll();

    @Insert("insert into user_info values(default, #{userName}, #{name}, #{password}, #{salt}, #{state})")
    int add(Map map);

    @Delete("delete from user_info where uid = #{uid}")
    int del(Integer id);

    @Update("update user_info set name = #{name}, password = #{password} where uid = 55")
    int update(Map map);
}
