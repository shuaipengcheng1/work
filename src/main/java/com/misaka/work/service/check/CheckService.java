package com.misaka.work.service.check;

import com.misaka.work.bean.UserDate;
import com.misaka.work.domain.Check;

import java.util.List;
import java.util.Map;

public interface CheckService {
//    签到
    Map<String,Object> check(Check check);
//    获取某一天签到的人
    List<Check> getList(UserDate date);
}
