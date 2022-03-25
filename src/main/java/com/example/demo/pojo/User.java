package com.example.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class User {

    // 将JSONField(name= "???")注释后,前端展示json形式将为POJO形式
    @JSONField(name = "用户ID")
    protected Integer user_id;
    @JSONField(name = "用户名")
    public String user_name;
    @JSONField(name = "用户密码")
    private String user_password;
    @JSONField(name = "建立时间")
    private String create_time;
    @JSONField(name = "更新时间")
    private String update_time;
    @JSONField(name = "逻辑删除")
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
