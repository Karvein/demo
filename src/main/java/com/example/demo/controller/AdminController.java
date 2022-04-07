package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Service.impl.AdminServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class AdminController {
    // 管理员控制接口
    // 依赖注入到服务接口调用
    @Resource
    private AdminServiceImpl adminServiceImpl;

    @RequestMapping("/findAdmin")
    public String findAdmin(String name, String password) {
        // 返回json字符串,其中前端传输的变量应未name和password而非VO类或POJO类的成员变量
        String jsonOutput = JSON.toJSONString(adminServiceImpl.findAdmin(name, password));
        return jsonOutput;
    }
}
