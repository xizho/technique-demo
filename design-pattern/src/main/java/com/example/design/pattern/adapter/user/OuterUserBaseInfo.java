package com.example.design.pattern.adapter.user;

import java.util.HashMap;
import java.util.Map;

public class OuterUserBaseInfo implements IOuterUserBaseInfo {
    @Override
    public Map getUserBaseInfo() {
        HashMap map = new HashMap();
        map.put("userName", "张三");
        map.put("mobileNumber", "这个员工的电话号。。。");
        return map;
    }
}
