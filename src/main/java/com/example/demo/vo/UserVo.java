package com.example.demo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class UserVo {
    // VO层将部分不返回给前端的值过滤，保证安全性
    // 将JSONField(name= "???", ordinal = ?), name为前端展示名, ordinal为展现次序
    // 使用JSON别名,可以调整顺序
    @JSONField(name = "用户名", ordinal = 1)
    // 使用Gson别名,
    // 对多种属性名不一致的情况,需要用到 SerializedName 注解的另一个属性值 alternate,
    // height, Height, mHeight字段名都能够被正常解析为"用户名"字段名。
    @SerializedName(value = "用户名",alternate = {"Height", "mHeight"})
    public String user_name;
    @JSONField(name = "用户密码", ordinal = 2)
    private String user_password;
}
