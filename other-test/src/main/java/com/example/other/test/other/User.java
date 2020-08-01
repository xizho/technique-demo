package com.example.other.test.other;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private ArrayList<String> list = new ArrayList<>();

    private String name;
    private Date birth;
    private int age;

    private Builder builder;


    public ArrayList<String> getList() {
        return list;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public int getAge() {
        return age;
    }

    public User() {
        this(new Builder());
    }

    public User(Builder builder) {
        this.list = builder.list;
        this.age = builder.age;
        this.birth = builder.birth;
        this.name = builder.name;
    }

    public User build() {
        return new User(builder);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static class Builder {
        private ArrayList<String> list = new ArrayList<>();

        private String name;
        private Date birth;
        private int age;

        public Builder() {
        }

        public Builder(User user) {
            this.list = user.list;
            this.name = user.name;
            this.birth = user.birth;
            this.age = user.age;
        }

        public Builder setList(ArrayList<String> list) {
            this.list = list;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBirth(Date birth) {
            this.birth = birth;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
