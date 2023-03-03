package com.reactiveProgramming.sec01;

import CourseUtil.Util;
import reactor.core.publisher.Mono;

public class MonoSubscribe {
    public static void main(String[] args) {

        //publicsher
        Mono<Integer> mono = Mono.just("ball")
                                .map(String::length)
                                .map(l->l/1);

//        mono.subscribe();

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
