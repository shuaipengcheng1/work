package com.misaka.work.domain;

import com.misaka.work.bean.UserDate;

//打卡信息对象
public class Check {
  public   int id;
  public   User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDate getUserDate() {
        return userDate;
    }

    public void setUserDate(UserDate userDate) {
        this.userDate = userDate;
    }

    public String getWorksite() {
        return worksite;
    }

    public void setWorksite(String worksite) {
        this.worksite = worksite;
    }

    UserDate userDate;
    String worksite;

    public Check(User user, UserDate userDate, String worksite) {
        this.user = user;
        this.userDate = userDate;
        this.worksite = worksite;
    }

    public Check() {
    }
}
