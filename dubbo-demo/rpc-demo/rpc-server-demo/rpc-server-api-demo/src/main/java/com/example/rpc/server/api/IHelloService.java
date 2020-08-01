package com.example.rpc.server.api;

public interface IHelloService {
    /**
     * 打招呼
     *
     * @param content
     * @return
     */
    String sayHello(String content);

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    String saveUser(User user);
}
