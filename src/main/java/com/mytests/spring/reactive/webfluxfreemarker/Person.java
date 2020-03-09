package com.mytests.spring.reactive.webfluxfreemarker;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2019.
 * Project: webflux-webclient-annotations-test
 * *******************************
 */
public class Person {

    String name;
    Integer id;
    Integer age;

    public Person(String name, Integer id, Integer age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }
}
