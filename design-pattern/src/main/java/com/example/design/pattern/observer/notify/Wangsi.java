package com.example.design.pattern.observer.notify;

public class Wangsi implements Observer {
    @Override
    public void update(String context) {
        System.out.println("王斯观察到韩非子的行动，向赵政汇报");
        this.cry(context);
        System.out.println("王斯汇报完毕！");
    }

    private void cry(String context) {
        System.out.println("王斯哭了，" + context);
    }
}
