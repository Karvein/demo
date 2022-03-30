package com.example.demo.Service;

import com.example.demo.pojo.User;
import com.example.demo.vo.UserVo;
import java.util.ArrayList;

public interface UserService {
    public ArrayList<UserVo> findAll();
    public UserVo findByName(String name);
    public int insert(User user);
    public int delete(User user);
//    public boolean alert(User user,String name,String password);

}
