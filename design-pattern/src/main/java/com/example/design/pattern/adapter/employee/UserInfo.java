package com.example.design.pattern.adapter.employee;

public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("员工的姓名");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("这里是员工的地址。。。");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("员工的手机号");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        System.out.println("员工的工作电话");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("员工的职位。。");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("员工的家庭电话。。。");
        return null;
    }
}
