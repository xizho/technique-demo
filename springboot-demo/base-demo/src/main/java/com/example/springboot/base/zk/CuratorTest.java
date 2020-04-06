package com.example.springboot.base.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;

import java.util.List;

public class CuratorTest {
    public static void main(String[] args) throws Exception {
        System.out.println("----- new client -----");
        CuratorFramework client = CuratorFrameworkFactory
                .newClient("192.168.248.129:2181", new RetryNTimes(10, 5000));
        System.out.println("----- new start -----");
        client.start();
        // 获取子节点
        System.out.println("----- get client -----");
        List<String> children = client
                .getChildren()
                .usingWatcher((CuratorWatcher) watchedEvent -> System.out.println("监控：" + watchedEvent))
                .forPath("/");
        System.out.println(children);
        // 创建节点
        String result = client
                .create()
                .withMode(CreateMode.PERSISTENT)
                .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                .forPath("/test", "Data".getBytes());
        System.out.println("----- create client -----");
        System.out.println(result);

        System.out.println("----- set data -----");
        // 设置节点数据
        client
                .setData()
                .forPath("/test", "111".getBytes());
        client
                .setData()
                .forPath("/test", "222".getBytes());
        System.out.println("----- delete data -----");
        // 删除节点
//        System.out.println(client.checkExists().forPath("/test"));
//        client.delete().withVersion(-1).forPath("/test");
//        System.out.println(client.checkExists().forPath("/test"));
        Thread.currentThread().join();
        System.out.println("----- client close -----");
        client.close();
        System.out.println("OK! ");
    }
}
