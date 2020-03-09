package com.mytests.spring.reactive.webfluxfreemarker;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 10/21/2019.
 * Project: webflux-freemarker
 * *******************************
 */
public interface PersonRepo {
    Flux<Person> getAllPersons();

    Mono<Person> getPersonById(Integer id);

    Flux<Person> getPersonsByName(String name);

    Flux<Person> getPersonsByAge(int age);
}
