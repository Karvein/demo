package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin {
    private int userId;
    private String userName;
    private String userPassword;
    private String authArea;
}
