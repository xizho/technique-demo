package com.example.dubbo.service.app;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "/dubbo/com.example.dubbo.provider.api.DemoService/providers/dubbo%253A%252F%252F192.168.248.1%253A20880%252Fcom.example.dubbo.provider.api.DemoService%253Fanyhost%253Dtrue%2526application%253Dhello-app%2526dubbo%253D2.6.0%2526generic%253Dfalse%2526interface%253Dcom.example.dubbo.provider.api.DemoService%2526methods%253Dhello%2526pid%253D9404%2526side%253Dprovider%2526timestamp%253D1585111916245,,v{s{31,s{'world,'anyone}}},1  response:: '/dubbo/com.example.dubbo.provider.api.DemoService/providers/dubbo%253A%252F%252F192.168.248.1%253A20880%252Fcom.example.dubbo.provider.api.DemoService%253Fanyhost%253Dtrue%2526application%253Dhello-app%2526dubbo%253D2.6.0%2526generic%253Dfalse%2526interface%253Dcom.example.dubbo.provider.api.DemoService%2526methods%253Dhello%2526pid%253D9404%2526side%253Dprovider%2526timestamp%253D1585111916245";
        url = decode(url);

        System.out.println(URLDecoder.decode(url, "UTF-8"));
    }

    static String decode(String encodeUrl) throws UnsupportedEncodingException {
        if (encodeUrl.contains("%")) {
            decode(URLDecoder.decode(encodeUrl, "UTF-8"));
        }

        return encodeUrl;
    }
}
