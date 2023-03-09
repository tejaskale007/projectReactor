package com.reactiveProgramming.sec01;

import CourseUtil.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {
    public static void main(String[] args) {
        Runnable notifyOnComplete = ()-> System.out.println("process is done. Sending Emails");

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(), Util.onError(), notifyOnComplete);
    }

    private static Runnable timeConsumingProcess(){
        return ()-> {
            Util.sleepSeconds(3);
            System.out.println("operation completed");
        };
    }
}
