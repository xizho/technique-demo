package com.example.other.test.json.jackson;

import com.example.other.test.model.Birth;
import com.example.other.test.model.People;
import com.example.other.test.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

/**
 * https://developer.ibm.com/zh/articles/jackson-advanced-application/
 */
public class Demo1 {

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("xizho");
        person.setAge(28);
        person.setSex(false);
//        person.setBirth(YearMonth.of(1992, 4));
        person.setBirth(new Birth("1992", "04"));
        person.setDate(new Date());
        System.out.println(person);

        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(person);
        System.out.println(s);

        // 将一个对象转化为另一个对象
        People people = om.convertValue(person, People.class);
        System.out.println(people);
    }

}
