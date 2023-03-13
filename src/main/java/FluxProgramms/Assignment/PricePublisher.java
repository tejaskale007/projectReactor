package FluxProgramms.Assignment;

import CourseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class PricePublisher {
    public static Flux<Integer> getPrice(){
        AtomicInteger atomicInteger = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i->atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5,5),
                        Integer::sum
                ));
    }
}
