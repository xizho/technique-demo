package com.example.design.pattern.adapter.user;

import java.util.HashMap;
import java.util.Map;

public class OuterUserHomeInfo implements IOuterUserHomeInfo {
    @Override
    public Map getUserHomeInfo() {
        HashMap map = new HashMap();
        map.put("homeTelNumber", "这个员工的家庭电话是。。。");
        map.put("homeAddress", "这个员工的家庭住址是。。。");
        return map;
    }
}
