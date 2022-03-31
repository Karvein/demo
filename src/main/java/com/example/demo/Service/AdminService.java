package com.example.demo.Service;

import com.example.demo.pojo.Admin;

public interface AdminService {
    public Admin findAdmin(String name, String password);
}
