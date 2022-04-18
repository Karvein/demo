package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.pojo.User;

import com.google.gson.Gson;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONTest {
    User user;

    @Test
    public void Gsontest(){
//      利用Gson实现将一个JSON转化为实体类
        String jsonIn = "{\"user_id\":30,\"user_name\":\"Joker\",\"user_password\":\"useP\",\"create_time\":\"2022-04-18 16:55:00\",\"update_time\":\"2022-04-18 16:55:00\",\"deleted\":0}";
//        Gson gson = new Gson();
//        user = gson.fromJson(jsonIn, User.class);
//      此处抛出空指针异常
//        System.out.println("1" + user.getUser_id());
        user = new Gson().fromJson(jsonIn, User.class);
        System.out.println(user.getUser_id());
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_password());
        System.out.println(user.getCreate_time());
        System.out.println(user.getUpdate_time());
        System.out.println(user.getDeleted());
        System.out.println(user.toString());
    }

    @Test
    public void Jsontest(){
//      利用Gson实现将一个JSON转化为实体类
        String jsonIn = "{\"user_id\":30,\"user_name\":\"Joker\",\"user_password\":\"useP\",\"create_time\":\"2022-04-18 16:55:00\",\"update_time\":\"2022-04-18 16:55:00\",\"deleted\":0}";
//        Gson gson = new Gson();
//        user = gson.fromJson(jsonIn, User.class);
//      此处抛出空指针异常
//        System.out.println("1" + user.getUser_id());
        user = JSON.parseObject(jsonIn,User.class);
        System.out.println(user.toString());
        System.out.println(user.getUser_id());
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_password());
        System.out.println(user.getCreate_time());
        System.out.println(user.getUpdate_time());
        System.out.println(user.getDeleted());

    }

//    @Test
//    public void time(){
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
//    }

}
