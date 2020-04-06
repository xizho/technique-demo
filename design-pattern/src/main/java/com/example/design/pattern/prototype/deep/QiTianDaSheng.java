package com.example.design.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

public class QiTianDaSheng extends Monkey implements Cloneable, Serializable {

    public JinGuBang jinGuBang;

    public QiTianDaSheng() {
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    /**
     * 深克隆
     *
     * @return
     */
    private Object deepClone() {
        /*try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream    oos  = new ObjectOutputStream(baos);
                ByteArrayInputStream  bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream     ois  = new ObjectInputStream(bais)
        ) {*/
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            QiTianDaSheng clone = (QiTianDaSheng) ois.readObject();
            clone.birthday = new Date();

            return clone;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public QiTianDaSheng shallowClone() {
        QiTianDaSheng clone = new QiTianDaSheng();
        clone.height = this.height;
        clone.weight = this.weight;
        clone.jinGuBang = this.jinGuBang;
        clone.birthday = new Date();

        return clone;
    }

}
