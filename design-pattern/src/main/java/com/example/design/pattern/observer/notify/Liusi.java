package com.example.design.pattern.observer.notify;

public class Liusi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("柳斯观察到韩非子的行动，向赵政汇报");
        this.happy(context);
        System.out.println("柳斯汇报完毕！");
    }

    private void happy(String context) {
        System.out.println("柳斯笑了，" + context);
    }
}
