package com.example.design.pattern.proxy.force;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ClientProxy {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("张三");
        IGamePlayer gamePlayerProxy = gamePlayer.getProxy();
        System.out.println("开始时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        gamePlayerProxy.login("zhangsan", "123456");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();

        try {
            TimeUnit.SECONDS.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("结束时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
