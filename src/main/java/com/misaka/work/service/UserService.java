package com.misaka.work.service;

import com.misaka.work.domain.User;

public interface UserService {
    public User login(User user);
    public User submit(User user);

}
