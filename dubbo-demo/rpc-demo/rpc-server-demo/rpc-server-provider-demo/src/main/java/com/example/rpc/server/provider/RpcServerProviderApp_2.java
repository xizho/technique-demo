package com.example.rpc.server.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.Iterator;

public class RpcServerProviderApp_2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.start();
        HashSet<String> set = new HashSet<>();
        Iterator<String> strIterator = set.iterator();
        while (strIterator.hasNext()) {
            String s = strIterator.next();
            System.out.println(s);
        }

    }

}
