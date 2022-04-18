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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
// 服务注解
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
/* @Transactional注解在类上说明对类中所有方法进行了事务管理，此处声明事务创建的方式，以及回滚类型*/
// 事务注解
public class UserServiceImpl implements UserService {
    // @Resource 和 @Autowired的区别
    // @Autowired可以对构造器、方法、参数、字段使用，@Resource只能对方法、字段使用
    // @Autowired默认是byType可以使用@Qualifier指定Name，@Resource默认ByName如果找不到则ByType
    // 使用@Autowired最好配合@Qualifier
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    // 声明了事务为只读,方法的@Transactional会覆盖类的事务声明
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
    @Transactional(readOnly = true)
    public UserVo findByName(String name) {
        User user = userMapper.selectByName(name);
        UserVo vo = new UserVo();
        vo.setUser_name(user.getUser_name());
        vo.setUser_password(user.getUser_password());
        return vo;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insert(User user) {
        userMapper.insert(user);
        return user.getUser_id();
    }
    @Override
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
