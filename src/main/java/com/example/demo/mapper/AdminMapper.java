package com.example.demo.mapper;

import com.example.demo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    public Admin findAdmin(String name, String password);

}
