package com.example.design.pattern.adapter.employee;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOuterUser {
    @Override
    public Map getUserBaseInfo() {
        HashMap map = new HashMap();
        map.put("userName", "张三");
        map.put("mobileNumber", "这个员工的电话号。。。");
        return map;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap map = new HashMap();
        map.put("officeTelNumber", "这个员工的工作电话是。。。");
        map.put("jobPosition", "这个员工的职位是。。。");
        return map;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap map = new HashMap();
        map.put("homeTelNumber", "这个员工的家庭电话是。。。");
        map.put("homeAddress", "这个员工的家庭住址是。。。");
        return map;
    }
}
