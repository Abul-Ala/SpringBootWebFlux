package com.springboot.webflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("abul")
                .then(Mono.error(new RuntimeException("exception occured")))
                .log();
        monoString.subscribe(System.out::println,(e)-> System.out.println(e.getMessage()));

    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("abul", "surender", "dinesh", "nishu")
                .concatWithValues("rohit").concatWith(Flux.error(new RuntimeException("error occue")))
                .log();
        fluxString.subscribe(System.out::println);
    }
}
