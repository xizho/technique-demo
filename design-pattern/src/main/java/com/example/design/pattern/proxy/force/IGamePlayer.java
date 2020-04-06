package com.example.design.pattern.proxy.force;

public interface IGamePlayer {
    public void login(String user, String pwd);

    public void killBoss();

    public void upgrade();

    public IGamePlayer getProxy();
}
