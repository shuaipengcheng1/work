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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> login(HttpServletRequest request, @RequestParam(value="username",required=true)String username, @RequestParam(value="password",required=true)String password){
        HashMap<String,Object> result = new HashMap<>();
        User user = new User(0,username,password);
       boolean flag = service.login(user);

       if(flag){
           result.put("message",true);
//           存cookie
           request.getSession().setMaxInactiveInterval(36000); //10h
           request.getSession().setAttribute("username",username);
       }else {
           result.put("message",false);

       }
       return result;
    }
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Map<String,Object> submit(HttpServletRequest request, @RequestParam(value="username",required=true)String username, @RequestParam(value="password",required=true)String password){
        HashMap<String,Object> result = new HashMap<>();
        User user = new User(0,username,password);
        boolean flag = service.submit(user);

        if(flag){
            result.put("message",true);
//           存cookie
            request.getSession().setMaxInactiveInterval(36000); //10h
            request.getSession().setAttribute("username",username);
        }else {
            result.put("message",false);

        }
        return result;
    }



}
