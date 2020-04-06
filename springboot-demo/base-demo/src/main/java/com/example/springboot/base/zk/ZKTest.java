package com.example.springboot.base.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ZKTest {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        System.out.println("----- new instance -----");
        ZooKeeper zk = new ZooKeeper("192.168.248.129:2181", 10000, event -> System.out.println("Watcher---->" + event.toString()));
        System.out.println("OK!");

        System.out.println("----- create node -----");
        zk.create("/country", "China".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create("/country/city", "China/Hangzhou".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zk.create("/country/city", "China/Shanghai".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("----- inquire current nodes -----");
        System.out.println(new String(zk.getData("/country", false, null)));
        System.out.println(zk.getChildren("/country", true));

        System.out.println("----- create another node -----");
        zk.create("/country/view", "China/WestLake".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(zk.getChildren("/country", true));

        System.out.println("----- modify node data -----");
        zk.setData("/country/city", "China/Suzhou".getBytes(), -1);
        byte[] datas = zk.getData("/country/city", true, null);
        String str = new String(datas, "UTF-8");
        System.out.println(str);

        System.out.println("----- delete whole directory -----");
        zk.delete("/path01/path01", -1);
        zk.delete("/path02/path02", -1);

        System.out.println(str);

        TimeUnit.SECONDS.sleep(10);

        zk.close();

        System.out.println("OK!");
    }
}
