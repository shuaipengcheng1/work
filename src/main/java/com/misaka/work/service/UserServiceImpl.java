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
    public boolean login(User user) {

//
//                判断
        User result = dao.checkLogin(user);
        if (result != null) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean submit(User user) {
        User result = dao.checkName(user.username);
        if (result != null) {
            return false;
        } else {
//            没重复
            int re = dao.addUser(user);
            if (re > 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
