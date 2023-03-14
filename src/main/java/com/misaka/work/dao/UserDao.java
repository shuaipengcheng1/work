package com.misaka.work.dao;

import com.misaka.work.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> getAllUser();
    public User getUserById(int id);
    public int addUser(User user);
    public User checkLogin(User user);
    public User checkName(String name);
}
