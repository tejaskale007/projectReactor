package com.reactiveProgramming.sec01;

import CourseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        getName();
        System.out.println(name);

        Util.sleepSeconds(8);
    }

    private static Mono<String> getName(){
        System.out.println("[getName]");
        return Mono.fromSupplier(()->{
                System.out.println("Generating name....");
                Util.sleepSeconds(2);
                return Util.FAKER.name().firstName();
        }).map(String::toUpperCase);
    }
}
