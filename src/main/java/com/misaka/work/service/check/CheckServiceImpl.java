package com.misaka.work.service.check;

import com.misaka.work.bean.UserDate;
import com.misaka.work.dao.CheckDao;
import com.misaka.work.domain.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    CheckDao dao;

    @Override
    public Map<String,Object> check(Check check) {
        HashMap<String,Object> map = new HashMap<>();
//        检查当天是否已经签到
        Check re = dao.check(check);
        if (re != null) {
            System.out.println("已经签到");
            map.put("message",false);
            map.put("reason","已经签到");
            return map; //已经签到
        }
        int result = dao.addCheck(check);
        if (result > 0) {
            map.put("message",true);
            map.put("reason","签到成功");
        } else{
            map.put("message",false);
            map.put("reason","服务器问题");
        }
        return map;

    }

    @Override
    public List<Check> getList(UserDate date) {

        return dao.getCheckList(date);
    }
}
