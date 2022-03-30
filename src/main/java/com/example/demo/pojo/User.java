package com.example.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class User {

    protected Integer user_id;
    public String user_name;
    private String user_password;
    private String create_time;
    private String update_time;
    private int deleted;

//    public void setUser_id(int id) {
//        user_id = id;
//    }
//
//    public void setUser_name(String name) {
//        user_name = name;
//    }
//
//    public void setUser_password(String password) {
//        user_password = password;
//    }
//
//    public int getUser_id() {
//        return this.user_id;
//    }
//
//    public String getUser_name() {
//        return this.user_name;
//    }
//
//    public String getUser_password() {
//        return this.user_password;
//    }
}
