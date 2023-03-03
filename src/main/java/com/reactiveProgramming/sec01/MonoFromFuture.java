package com.reactiveProgramming.sec01;

import CourseUtil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(MonoFromFuture::getName)
                .subscribe(Util.onNext());

        Util.sleepSeconds(3);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> Util.faker().name().fullName());
    }
}
