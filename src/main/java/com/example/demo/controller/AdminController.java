package com.example.demo.controller;

import com.example.demo.Service.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
/*
* @RestController限定了RequestMapping的返回只能是String,无法使用重定向
* @Controller可使用redirect:/url进行重定向
* */
@Controller
@RequestMapping("/admins")
public class AdminController {
    // 管理员控制接口
    // 依赖注入到服务接口调用
    @Resource
    private AdminServiceImpl adminServiceImpl;

    // 此处代码有误,无法解析前端传输的string
//    @RequestMapping("/login")
//    public String findAdmin(String json) {
//        // 接收json输入,按照传输进入的数据转化为vo类,再返回json结果
//        System.out.println(json);
//        UserVo uservo = JSON.parseObject(json, UserVo.class);
//        if (!(adminServiceImpl.findAdmin(uservo.getUser_name(), uservo.getUser_password()).getUserId() >= 0)) {
//            return "empty input";
//        } else {
//            return String.valueOf(adminServiceImpl.findAdmin(uservo.getUser_name(), uservo.getUser_password()).getUserId());
//        }
//    }
    @RequestMapping("/login")
    public String findAdmin(@RequestParam String name ,@RequestParam String pwd) {
        adminServiceImpl.findAdmin(name,pwd);
        // 重定向失败
        return "redirect:/users/findAll";
    }
}
