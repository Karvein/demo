package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.pojo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userInfoPage")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    // 返回形式为list形式
/*    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userServiceImpl.findAll();
    }*/

    // 返回形式为fastjson
    @RequestMapping("/findAll")
    public String findAll() {
        String jsonOutput = JSON.toJSONString(userServiceImpl.findAll());
        return jsonOutput;
    }

    /*
    // 返回形式为Gson
    @RequestMapping("/findAll")
    public String findAll() {
        String jsonOutput = JSON.toJSONString(userServiceImpl.findAll());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formatStr = gson.toJson(jsonOutput);
        return formatStr;
    }
    */

    @RequestMapping("/findByName")
    public User findByName(String name) {
        return userServiceImpl.findByName(name);
    }

    @RequestMapping("/insert")
    public int insert(User user) {
        return userServiceImpl.insert(user);
    }

    @RequestMapping("/delete")
    public int delete(User user) {
        return userServiceImpl.delete(user);
    }
}
