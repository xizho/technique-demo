package com.example.design.pattern.adapter.user;

import com.example.design.pattern.adapter.employee.IUserInfo;

import java.util.Map;

public class OuterUserInfo implements IUserInfo {
    private IOuterUserBaseInfo baseInfo;
    private IOuterUserOfficeInfo officeInfo;
    private IOuterUserHomeInfo homeInfo;

    private Map baseMap;
    private Map officeMap;
    private Map homeMap;

    public OuterUserInfo(IOuterUserBaseInfo baseInfo, IOuterUserOfficeInfo officeInfo, IOuterUserHomeInfo homeInfo) {
        this.baseInfo = baseInfo;
        this.officeInfo = officeInfo;
        this.homeInfo = homeInfo;

        this.baseMap = baseInfo.getUserBaseInfo();
        this.officeMap = officeInfo.getUserOfficeInfo();
        this.homeMap = homeInfo.getUserHomeInfo();
    }

    @Override
    public String getUserName() {
        String userName = (String) baseMap.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String) homeMap.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        String mobileNumber = (String) baseMap.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String) officeMap.get("officeTelNumber");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = (String) officeMap.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String) homeMap.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
}
