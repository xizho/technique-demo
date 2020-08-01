package com.example.rpc.server.provider;

import com.example.rpc.server.api.IHelloService;
import com.example.rpc.server.api.User;

@RpcService(value = IHelloService.class, version = "2.0")
public class HelloServiceImpl_2 implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("[V2.0]request in sayHello :" + content);
        return "[V2.0]Say hello, " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("[V2.0]request in saveUser :" + user);
        return "[V2.0]Success";
    }
}
