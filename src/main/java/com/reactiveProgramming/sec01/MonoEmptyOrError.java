package com.reactiveProgramming.sec01;

import CourseUtil.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(1)                   //userRepository acting as publisher
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static Mono<String> userRepository(int userId){
        if(userId==1){
            return Mono.just(Util.FAKER.name().firstName());
        }else if(userId == 2){
            return Mono.empty(); //null
        }else
            return Mono.error(new RuntimeException("userId not in allowed range"));
    }
}
