package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectAll();
    public User selectByName(String name);
    public int insert(User user);
    public Boolean delete(User user);
}
