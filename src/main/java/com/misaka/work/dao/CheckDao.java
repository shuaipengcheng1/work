package com.misaka.work.dao;

import com.misaka.work.bean.UserDate;
import com.misaka.work.domain.Check;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckDao {
    int addCheck(Check check);
    List<Check> getCheckList(UserDate date);
}
