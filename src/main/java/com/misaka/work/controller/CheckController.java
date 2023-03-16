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

import java.util.*;

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
        Calendar calendar = Calendar.getInstance();
//        // 获取当前年
//        int year = calendar.get(Calendar.YEAR);
//// 获取当前月
//        int month = calendar.get(Calendar.MONTH) + 1;
//// 获取当前日
//        int day = calendar.get(Calendar.DATE);
if(Objects.equals(year, String.valueOf(calendar.get(Calendar.YEAR)))&&Objects.equals(mouth,String.valueOf(calendar.get(Calendar.MONTH) + 1))&&Objects.equals(day,String.valueOf(calendar.get(Calendar.DATE)))){
    User user = new User();
    user.username = username;
    UserDate date = new UserDate(day, mouth, year, time);
    Check check = new Check(user, date, worksite);
    check.id = 0;
    return checkService.check(check);
}else {
    Map<String,Object> re = new HashMap<>();
    re.put("message",false);
    re.put("reason","时间错误");
    return re;
}






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
