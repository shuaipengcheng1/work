package com.misaka.work.controller;

import com.misaka.work.bean.UserDate;
import com.misaka.work.domain.Check;
import com.misaka.work.domain.User;
import com.misaka.work.service.check.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CheckController {
    @Autowired
    CheckService checkService;

    @RequestMapping(value = "/check", method = RequestMethod.PUT)
    public Map<String, Object> check(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "worksite") String worksite,
                                     @RequestParam(value = "time") String time,
                                     @RequestParam(value = "year") String year,
                                     @RequestParam(value = "mouth") String mouth,
                                     @RequestParam(value = "day") String day) {
        HashMap<String, Object> result = new HashMap<>();
        User user = new User();
        user.username = username;
        UserDate date = new UserDate(day, mouth, year, time);
        Check check = new Check(user, date, worksite);
        check.id = 0;
        boolean re = checkService.check(check);
        if (re) {
            result.put("message", true);
        } else {
            result.put("message", false);

        }
        return result;


    }

    @RequestMapping(value = "/getCheckList",method = RequestMethod.GET)
    public Map<String,Object> getCheckList(@RequestParam(value = "day")String day,@RequestParam(value = "year")String year,@RequestParam(value = "mouth")String mouth){
        UserDate date = new UserDate(day,mouth,year);
        HashMap<String, Object> result = new HashMap<>();
        List<Check> list=checkService.getList(date);
        result.put("message",true);
        result.put("result",list);
        return result;




    }

}
