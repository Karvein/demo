package com.example.demo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class UserVo {
    // VO层将部分不返回给前端的值过滤，保证安全性
    // 将JSONField(name= "???", ordinal = ?), name为前端展示名, ordinal为展现次序
    @JSONField(name = "用户名", ordinal = 2)
    public String user_name;
    @JSONField(name = "用户密码", ordinal = 3)
    private String user_password;
}
