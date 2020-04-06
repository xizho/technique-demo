package com.example.other.test.http.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待连接。。。");
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        StringBuilder content = new StringBuilder();
        int length = 0;
        while ((length = is.read(bytes)) != -1) {
            content.append(new String(bytes, 0, length, "UTF-8"));
        }

        System.out.println("得到客户端的消息:" + content);
//        is.close();
        System.out.println("Server即将关闭连接。。。");
        socket.shutdownOutput();
//        socket.shutdownInput();
//        socket.close();
//        server.close();

        System.out.println(socket.isInputShutdown());
        System.out.println(socket.isOutputShutdown());
        System.out.println(server.isClosed());
    }
}
