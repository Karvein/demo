package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
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

    // 这里定义的变量为url传输时使用的变量,名称需一致
    @RequestMapping("/findByName")
    public String findByName(String user_name) {
        String jsonOutput = JSON.toJSONString(userServiceImpl.findByName(user_name));
        return jsonOutput;
    }

    // 此处定义的User,url内传输的值需与User类内的成员变量一致
    @RequestMapping("/insert")
    public int insert(User user) {
        return userServiceImpl.insert(user);
    }

    @RequestMapping("/delete")
    public int delete(User user) {
        return userServiceImpl.delete(user);
    }

//    @RequestMapping("/ask")
//    public String display(){
//        return "You have asked once";
//    }
}
