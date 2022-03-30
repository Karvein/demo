package com.example.demo.Service;

import com.example.demo.pojo.User;
import com.example.demo.vo.UserVo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    public ArrayList<UserVo> findAll();
    public User findByName(String name);
    public int insert(User user);
    public int delete(User user);
//    public boolean alert(User user,String name,String password);

}
