package com.example.concurrent.monitor.observer.service;

/**
 * 类职责：<br/>
 *
 * <p>Title: ITask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017 </p>
 * <p>Company: </p>
 *
 * <p>Author:Seen</p>
 * <p>CreateTime:2018年12月07日 下午下午 4:43
 * <p></p>
 * <p> </p>
 * <p> </p>
 * <p> </p>
 */
public interface ITask<T> {

    /**
     * 任务执行
     *
     * @return
     */
    T call();
}
