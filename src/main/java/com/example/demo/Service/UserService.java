package com.example.demo.Service;

import com.example.demo.pojo.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public interface UserService {
    public List<User> findAll();
    public User findByName(String name);
    public int insert(User user);
//    public boolean alert(User user,String name,String password);

}
