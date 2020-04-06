package com.example.design.pattern.adapter.user;

import java.util.HashMap;
import java.util.Map;

public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {
    @Override
    public Map getUserOfficeInfo() {
        HashMap map = new HashMap();
        map.put("officeTelNumber", "这个员工的工作电话是。。。");
        map.put("jobPosition", "这个员工的职位是。。。");
        return map;
    }
}
