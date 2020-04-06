package com.example.design.pattern.observer.sample;

public class Hanfeizi implements IHanfeizi {
    private boolean isHavingBreakfast;
    private boolean isHavingFun;

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子开始吃早饭了。。。");
        this.isHavingBreakfast = true;
    }

    @Override
    public void hanFun() {
        System.out.println("韩非子开始娱乐了。。。");
        this.isHavingFun = true;
    }

    public boolean isHavingBreakfast() {
        return isHavingBreakfast;
    }

    public void setHavingBreakfast(boolean havingBreakfast) {
        isHavingBreakfast = havingBreakfast;
    }

    public boolean isHavingFun() {
        return isHavingFun;
    }

    public void setHavingFun(boolean havingFun) {
        isHavingFun = havingFun;
    }
}
