package com.example.springboot.base;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.Charset;

@SpringBootApplication
public class BaseDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BaseDemoApplication.class, args);
        HashFunction hashFunction = Hashing.md5();
        HashCode hashCode = hashFunction.hashString("123123123123", Charset.defaultCharset());
        System.out.println(hashCode);
    }

}

