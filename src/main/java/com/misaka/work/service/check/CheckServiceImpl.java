package com.misaka.work.service.check;

import com.misaka.work.bean.UserDate;
import com.misaka.work.dao.CheckDao;
import com.misaka.work.domain.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    CheckDao dao;

    @Override
    public boolean check(Check check) {
        int result = dao.addCheck(check);
        if (result > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public List<Check> getList(UserDate date) {

        return dao.getCheckList(date);
    }
}
