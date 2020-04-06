package com.example.design.pattern.proxy.force;

public class GamePlayer implements IGamePlayer {
    private String name;
    private IGamePlayer gamePlayer;

    public GamePlayer() {
    }

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String user, String pwd) {
        if (isProxy()) {
            System.out.println("登录名为" + user + "的用户" + name + "登陆成功!");
        } else {
            System.out.println("请用指定的代理访问！！！");
        }
    }

    @Override
    public void killBoss() {
        if (isProxy()) {
            System.out.println(this.name + "在打怪！");
        } else {
            System.out.println("请用指定的代理访问！！！");
        }
    }

    @Override
    public void upgrade() {
        if (isProxy()) {
            System.out.println(this.name + "又升级了！");
        } else {
            System.out.println("请用指定的代理访问！！！");
        }
    }

    private boolean isProxy() {
        if (this.gamePlayer == null) {
            return false;
        }

        return true;
    }

    @Override
    public IGamePlayer getProxy() {
        this.gamePlayer = new GamePlayerProxy(this);
        return gamePlayer;
    }
}
