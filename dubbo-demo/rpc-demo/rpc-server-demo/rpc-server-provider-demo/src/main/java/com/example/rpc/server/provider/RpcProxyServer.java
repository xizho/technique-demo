package com.example.rpc.server.provider;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 暴漏服务
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(Object service, int port) {
        System.out.println("发布服务[" + service + "]到端口：" + port);
        System.out.println();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
//                executorService.execute(new ProcessorHandler(service, socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
