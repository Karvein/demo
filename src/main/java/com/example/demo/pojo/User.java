package com.example.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

@Component
public class User {

    @JSONField(name = "USER_ID")
    protected Integer user_id;
    @JSONField(name = "USER_NAME")
    public String user_name;
    @JSONField(name = "USER_PASSWORD")
    private String user_password;

    public void setUser_id(int id) {
        user_id = id;
    }

    public void setUser_name(String name) {
        user_name = name;
    }

    public void setUser_password(String password) {
        user_password = password;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public String getUser_password() {
        return this.user_password;
    }
}
