package com.example.design.pattern.proxy.dynamic;

public class GamePlayer implements IGamePlayer {
    private String name;

    public GamePlayer() {
    }

    public GamePlayer(String name) {
        this.name = name;
    }

    public GamePlayer(IGamePlayer gamePlayer, String name) throws Exception {
        if (gamePlayer == null) {
            throw new Exception("创建角色失败！");
        } else {
            this.name = name;
        }
    }

    @Override
    public void login(String user, String pwd) {
        System.out.println("登录名为" + user + "的用户" + name + "登陆成功!");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + "又升级了！");
    }
}
