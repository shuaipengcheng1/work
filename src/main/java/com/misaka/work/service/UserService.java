package com.misaka.work.service;

import com.misaka.work.domain.User;

public interface UserService {
    public boolean login(User user);
    public boolean submit(User user);

}
