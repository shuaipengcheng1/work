package com.misaka.work.controller;

import com.misaka.work.domain.User;
import com.misaka.work.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) {

        User user = new User(0, username, password);
        User flag = service.login(user);

        return getResult(flag, request);

    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Map<String, Object> submit(HttpServletRequest request, @RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) {
        User user = new User(0, username, password);
        User flag = service.submit(user);
        return getResult(flag, request);
    }

    public Map<String, Object> getResult(User flag, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();

        if (flag != null) {
            result.put("message", true);
            result.put("result", flag);

//           存cookie
            request.getSession().setMaxInactiveInterval(36000); //10h
            request.getSession().setAttribute("username", flag.username);
        } else {
            result.put("message", false);
            result.put("result", null);


        }
        return result;
    }


}
