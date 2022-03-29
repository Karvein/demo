package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
// 服务注解
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
// 事务注解
//@ComponentScan("com.example.demo.mapper")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
    public User findByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert(User user) {
        userMapper.insert(user);
        return user.getUser_id();
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int delete(User user) {
        if (user.getDeleted() == 0) {
            userMapper.delete(user);
            return 1;
        } else {
            System.out.println("Already deleted.");
            return -1;
        }
    }
}
