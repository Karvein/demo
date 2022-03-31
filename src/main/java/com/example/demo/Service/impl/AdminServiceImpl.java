package com.example.demo.Service.impl;

import com.example.demo.Service.AdminService;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.pojo.Admin;
import com.example.demo.pojo.User;
import com.example.demo.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService{
    @Resource
    private AdminMapper adminMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,readOnly = true)
    public Admin findAdmin(String name, String password) {
        return adminMapper.findAdmin(name, password);
    }
}
