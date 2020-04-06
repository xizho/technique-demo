package com.example.design.pattern.prototype.adv.clone;

import com.example.design.pattern.prototype.adv.AdvTemplate;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Client {
    private static int MAX_COUNT = 6;

    public static void main(String[] args) throws CloneNotSupportedException {
        Instant start = Instant.now();
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("XX银行版权所有");
        int i = 0;
        while (i < MAX_COUNT) {
            String name = getRandString(5);
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(name + " 先生（女士）");
            cloneMail.setReceiver(name + "@" + getRandString(8) + ".com");
//            sendMail(mail);
            i++;
        }

        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + " ms");
    }

    private static void sendMail(Mail mail) {
        System.out.println("标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t...发送成功");
    }

    static String getRandString(int length) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(source.charAt(r.nextInt(source.length())));
        }

        return sb.toString();
    }

    static String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
}
