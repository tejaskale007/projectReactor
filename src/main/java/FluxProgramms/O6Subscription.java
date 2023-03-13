package FluxProgramms;

import CourseUtil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class O6Subscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1,20).log().subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Received Sub: "+s);
                atomicReference.set(s);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("OnNext"+ integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("OnError: "+ t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel(); //once cancelled you can't expect the publisher to emit items, nor the request will be entertained
        Util.sleepSeconds(3);
        atomicReference.get().request(4);
    }
}
