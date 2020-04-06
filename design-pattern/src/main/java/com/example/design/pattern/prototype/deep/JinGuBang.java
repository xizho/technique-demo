package com.example.design.pattern.prototype.deep;

import java.io.Serializable;

public class JinGuBang implements Serializable {

    public float h = 108000;

    public float d = 100;

    public void big() {
        this.d *= 2;
        this.h *= 2;
    }

    public void small() {
        this.d /= 2;
        this.h /= 2;
    }

}
