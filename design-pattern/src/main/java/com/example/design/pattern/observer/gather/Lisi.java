package com.example.design.pattern.observer.gather;

public class Lisi implements ILisi {
    @Override
    public void update(String context) {
        System.out.println("李斯观察到韩非子的行动，向赵政汇报");
        this.reportToQSH(context);
        System.out.println("李斯汇报完毕！");
    }

    private void reportToQSH(String context) {
        System.out.println("李斯报告陛下，韩非子动了，" + context);
    }
}
