package com.example.design.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * 动态代理：JDK
 */
public class ClientProxy {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("张三");
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        System.out.println("开始时间：" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        ClassLoader cl = gamePlayer.getClass().getClassLoader();
        IGamePlayer gamePlayerProxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
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
