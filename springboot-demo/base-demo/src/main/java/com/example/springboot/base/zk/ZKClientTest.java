package com.example.springboot.base.zk;

import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class ZKClientTest {
    public static void main(String[] args) {
        System.out.println("----- new instance -----");
        ZkClient zkClient = new ZkClient("192.168.248.129:2181");
        zkClient.create("/root", "mydata", CreateMode.PERSISTENT);
        zkClient.create("/root", "mydata2", CreateMode.PERSISTENT);
        zkClient.create("/root", "mydata3", CreateMode.PERSISTENT);
        System.out.println("----- inquire data -----");
        String data = zkClient.readData("/root");
        System.out.println(data);

    }
}
