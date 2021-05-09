package com.example.concurrent.sample.future;

/**
 * 类职责：<br/>
 *
 * <p>Title: FutureData.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2019年02月15日 下午 1:26
 * <p></p>
 * <p> </p>
 */
public class FutureData implements Data {

    protected RealData realData = null;

    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;

        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return realData.result;
    }
}
