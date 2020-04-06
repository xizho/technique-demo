package com.example.design.pattern.adapter.user;

import com.example.design.pattern.adapter.employee.IUserInfo;

public class ClientMain {
    public static void main(String[] args) {
        IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
        IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();

        IUserInfo youngGirl = new OuterUserInfo(baseInfo, officeInfo, homeInfo);
        for (int i = 0; i < 100; i++) {
            youngGirl.getMobileNumber();
        }
    }
}
