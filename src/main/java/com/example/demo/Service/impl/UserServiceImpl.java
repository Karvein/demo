package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
// 服务注解
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
// 事务注解
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
    public ArrayList<UserVo> findAll() {
        ArrayList<UserVo> userVos = new ArrayList<>();
        List<User> users = userMapper.selectAll();
        for (User user: users
             ) {
            UserVo vo = new UserVo();
            vo.setUser_name(user.getUser_name());
            vo.setUser_password(user.getUser_password());
            userVos.add(vo);
        }
        return userVos;
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
    public int delete(User userVo) {
        if (userVo.getDeleted() == 0) {
            userMapper.delete(userVo);
            return 1;
        } else {
            System.out.println("Already deleted.");
            return -1;
        }
    }
}
