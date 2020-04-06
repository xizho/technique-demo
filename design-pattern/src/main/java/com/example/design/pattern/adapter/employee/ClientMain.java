package com.example.design.pattern.adapter.employee;

public class ClientMain {
    public static void main(String[] args) {
        IUserInfo youngGirl = new UserInfo();
        for (int i = 0; i < 100; i++) {
            youngGirl.getMobileNumber();
        }
    }
}
