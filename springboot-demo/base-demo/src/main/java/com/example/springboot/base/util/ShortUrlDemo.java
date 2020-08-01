package com.example.springboot.base.util;

import com.google.common.hash.*;

import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo 首次生成short url大概时间1000多ms，之后再生成就100ms左右了，为什么？？？？？
 * 2020年4月16日 13点31分 ：猜测可能是JIT做过优化
 */
public class ShortUrlDemo {
    static String url_prefix = "https://common.test/api/client?orderNo=";

    static String _62bit = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    static AtomicInteger count = new AtomicInteger(); // TODO 更好的方式，使用redis的自增函数

    static String dupPrefix = "dup_";

    static List<String> urlLog = new ArrayList<>();

    static ExecutorService executorService = Executors.newCachedThreadPool();

    static HashFunction murmurHash = Hashing.murmur3_32(0x123456);


    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            test();

            try {
                TimeUnit.MILLISECONDS.sleep(1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!executorService.isTerminated()) {
            System.out.println(executorService.toString());
            executorService.shutdown();
        }
    }

    static void test() {
        System.out.println("****************开始****************");
        Instant start = Instant.now();
        Set<String> shortUtlSet = new HashSet<>();
        for (int i = 0; i < 1_0; i++) {
            String uuid = UUID.randomUUID().toString();
            String url = url_prefix + uuid;
//            int hashCode = getHash2(url);
            int hashCode = getHash(url);
            String shortUrl = convert(hashCode);

            while (shortUtlSet.contains(shortUrl)) {
                String prefix = dupPrefix + count.getAndDecrement();
                url = prefix + url;
                String finalUrl = url;
                executorService.submit(() -> urlLog.add(finalUrl));
//                urlLog.add(finalUrl);
//                shortUrl = convert(getHash2(url));
                shortUrl = convert(getHash(url));
            }


            shortUtlSet.add(shortUrl);
        }
//        System.out.println(shortUtlSet.size());
        Instant end = Instant.now();

        System.out.println("耗时：" + Duration.between(start, end).toMillis() + " ms");
        System.out.println("打印日志。");

        System.out.println("重复的数量：" + urlLog.size());
//        System.out.println(Arrays.asList(urlLog.toArray()));

        urlLog.clear();
        shortUtlSet.clear();

        System.out.println("****************结束****************");
    }

    static int getHash(String url) {
        HashCode hashCode = murmurHash.hashString(url, Charset.defaultCharset());
        return hashCode.asInt();
    }

    static int getHash2(String url) {
        HashFunction murmurHash = Hashing.murmur3_32();
        Hasher hasher = murmurHash
                .newHasher()
                .putString(url, Charset.defaultCharset())
                .putString("test", Charset.defaultCharset());
        HashCode hashCode = hasher.hash();
        return hashCode.asInt();
    }

    static String convert(int hashCode) {
        return result(hashCode & Integer.MAX_VALUE);
    }

    static String result(int hashCode) {
        StringBuilder shortUrl = new StringBuilder();
        while (hashCode > 0) {
            int a = hashCode % 62;
            hashCode = hashCode / 62;

            shortUrl.append(_62bit.charAt(a));
        }

        return shortUrl.reverse().toString();
    }

    static void bloom(String shortUrl) {

        long inserts = expect(6);
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), inserts);

        boolean isContain = bloomFilter.mightContain(shortUrl);

    }

    static long expect(int power) {
        int count = 0;
        long result = 62L;
        while (count <= power) {
            result *= result;
        }

        return result;
    }
}
