package com.mytests.spring.reactive.webfluxfreemarker;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2019.
 * Project: webflux-webclient-annotations-test
 * *******************************
 */
@Repository
public class ReactivePersonRepo implements PersonRepo {

    private static List<Person> personList = new ArrayList<>() ;
    static {

        personList.add(new Person("irina",1, 49));
        personList.add(new Person("vera",2, 23));
        personList.add(new Person("andrey",3, 49));
        personList.add(new Person("lena",4, 49));
        personList.add(new Person("katya",5, 26));
        personList.add(new Person("natasha",6, 72));
        personList.add(new Person("andrey",7, 74));
    }
    @Override
    public Flux<Person> getAllPersons(){
        return Flux.fromIterable(personList);
    }
    @Override
    public Mono<Person> getPersonById(Integer id){
        Person rez = new Person("not found", 0, 0);
        for (Person person : personList) {
            if (person.getId().equals(id)){rez = person;}
        }
        return Mono.just(rez);
    }
    @Override
    public Flux<Person> getPersonsByName(String name){
        List<Person> rez = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().equals(name)){rez.add(person);}
        }
        return Flux.fromIterable(rez);
    }
    @Override
    public Flux<Person> getPersonsByAge(int age){
        List<Person> rez = new ArrayList<>();
        for (Person person : personList) {
            if (person.getAge()>= age){rez.add(person);}
        }
        return Flux.fromIterable(rez);
    }
}
