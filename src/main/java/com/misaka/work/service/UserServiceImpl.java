package com.misaka.work.service;

import com.misaka.work.dao.UserDao;
import com.misaka.work.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    @Override
    public User login(User user) {

//
//                判断
        User result = dao.checkLogin(user);
        if (result != null) {
            result.password = null;
            return result;
        } else
            return null;
    }

    @Override
    public User submit(User user) {
        User result = dao.checkName(user.username);
        if (result != null) {
            return null;
        } else {
//            没重复
            int re = dao.addUser(user);
            if (re > 0) {
                user.password = null;
                return user;
            } else {
                return null;
            }
        }

    }
}
