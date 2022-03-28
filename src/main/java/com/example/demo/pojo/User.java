package com.example.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class User {

    // 将JSONField(name= "???", ordinal = ?), name为前端展示名, ordinal为展现次序
    @JSONField(name = "用户ID", ordinal = 1)
    protected Integer user_id;
    @JSONField(name = "用户名", ordinal = 2)
    public String user_name;
    @JSONField(name = "用户密码", ordinal = 3)
    private String user_password;
    @JSONField(name = "建立时间", ordinal =5)
    private String create_time;
    @JSONField(name = "更新时间", ordinal = 6)
    private String update_time;
    @JSONField(name = "逻辑删除", ordinal = 4)
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
