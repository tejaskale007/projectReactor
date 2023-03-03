package com.reactiveProgramming.sec01;

import CourseUtil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class MonoFromSupplier {
    public static void main(String[] args) {
        //use just only when you have data already
        Mono.just(getName());


        System.out.println("From Supplier:");
        Mono<String> mono = Mono.fromSupplier(()->getName());
        mono.subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        System.out.println("\nFrom Callable");
        Callable<String> callableString = ()->getName();
        Mono.fromCallable(callableString).subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }

    private static String getName(){
        System.out.println("Generating name....");
        return Util.FAKER.name().firstName();
    }
}
