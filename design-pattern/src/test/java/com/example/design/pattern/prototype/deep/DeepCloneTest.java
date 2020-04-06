package com.example.design.pattern.prototype.deep;

public class DeepCloneTest {

    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        try {
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println("Deep clone : " + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        QiTianDaSheng qiTianDaSheng2 = new QiTianDaSheng();

        QiTianDaSheng shallowClone = qiTianDaSheng2.shallowClone();
        System.out.println("Shallow clone : " + (qiTianDaSheng2.jinGuBang == shallowClone.jinGuBang));
    }

}