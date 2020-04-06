package com.example.other.test.http.socket.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream os = socket.getOutputStream();
        String content = "你好，服务器，我测试一下Socket，套接字。";
        os.write(content.getBytes("UTF-8"));

//        os.close();
        System.out.println("Client即将关闭连接。。。");
        socket.shutdownOutput();
//        socket.shutdownInput();
        System.out.println(socket.isOutputShutdown());

//        socket.close();
    }
}
