package com.reactiveProgramming.sec01;

public class MonoExample {
    public static void main(String[] args) {

        reactor.core.publisher.Mono<Integer> mono = reactor.core.publisher.Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i-> System.out.println("Received: "+i));
    }
}
