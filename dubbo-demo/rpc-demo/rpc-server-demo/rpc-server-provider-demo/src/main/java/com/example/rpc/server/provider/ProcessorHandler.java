package com.example.rpc.server.provider;

import com.example.rpc.server.api.RpcRequest;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ProcessorHandler implements Runnable {
    private Socket socket;
    private Map<String, Object> handlerMap;

    public ProcessorHandler(Map<String, Object> handlerMap, Socket socket) {
        this.handlerMap = handlerMap;
        this.socket = socket;
    }


    @Override
    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest = (RpcRequest) ois.readObject();
            Object result = invoke(rpcRequest);
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(result);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Object invoke(RpcRequest rpcRequest) throws Exception {
        String serviceName = rpcRequest.getClassName();
        String version = rpcRequest.getVersion();
        if (!StringUtils.isEmpty(version)) {
            serviceName += "-" + version;
        }
        Object service = handlerMap.get(serviceName);

        if (service == null) {
            throw new RuntimeException("service not fund : " + serviceName);
        }

        Object[] args = rpcRequest.getParams();
        Class<?>[] klasses = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            klasses[i] = args[i].getClass();
        }

        Class<?> aClass = Class.forName(rpcRequest.getClassName());
        Method method = aClass.getMethod(rpcRequest.getMethodName(), klasses);

        return method.invoke(service, args);
    }
}
