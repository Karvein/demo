package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.pojo.User;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return JSON.toJSONString(userServiceImpl.findAll());
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
    // 此处使用Gson返回
    // @RequestParam定义url传输参数,value为变量名,required为是否为空,true时为空会报错,defaultValue为默认值
    @RequestMapping("/findByName")
    public String findByName(@RequestParam(value = "name", required = false, defaultValue = "null") String user_name) {
//        String jsonOutput = JSON.toJSONString(userServiceImpl.findByName(user_name));
//        String gsonOutput = new Gson().toJson(userServiceImpl.findByName(user_name));
        return new Gson().toJson(userServiceImpl.findByName(user_name));

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
