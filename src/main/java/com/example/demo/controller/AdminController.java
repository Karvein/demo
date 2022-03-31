package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Service.impl.AdminServiceImpl;
import com.example.demo.pojo.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class AdminController {
    @Resource
    private AdminServiceImpl adminServiceImpl;

    @RequestMapping("/findAdmin")
    public String findAdmin(String name, String password) {
        String jsonOutput = JSON.toJSONString(adminServiceImpl.findAdmin(name, password));
        return jsonOutput;
    }
}
