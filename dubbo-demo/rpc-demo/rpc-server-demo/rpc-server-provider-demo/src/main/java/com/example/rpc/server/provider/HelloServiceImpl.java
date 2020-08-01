package com.example.rpc.server.provider;

import com.example.rpc.server.api.IHelloService;
import com.example.rpc.server.api.User;

@RpcService(value = IHelloService.class, version = "1.0")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String content) {
        System.out.println("[V1.0]request in sayHello :" + content);
        return "[V1.0]Say hello, " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("[V1.0]request in saveUser :" + user);
        return "[V1.0]Success";
    }
}
