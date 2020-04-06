package com.example.design.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class Lisi implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("李斯观察到韩非子的行动，向赵政汇报");
        this.reportToQSH(arg.toString());
        System.out.println("李斯汇报完毕！");
    }

    private void reportToQSH(String context) {
        System.out.println("李斯报告陛下，韩非子动了，" + context);
    }
}
