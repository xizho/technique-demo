package com.example.other.test.other;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

@Component
public class LocaleTest {

    @Resource
    MessageSource messageSource;

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        System.out.println(locale.getLanguage());
        locale = new Locale("en", "US");
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());
//        System.out.println(locale.get);


    }

    private void message() {
        Locale locale = new Locale("en");
        String message = messageSource.getMessage("ECA0000001", null, locale);
        System.out.println("message: " + message);

    }


    public void application() {
        ApplicationContext ac = new ClassPathXmlApplicationContext();
//        ac.


    }

}
