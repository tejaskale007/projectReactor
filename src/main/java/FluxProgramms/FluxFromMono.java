package FluxProgramms;

import CourseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);

        doSomething(flux);
    }

    private static void doSomething(Flux<String> flux){
        flux.subscribe(Util.onNext());
    }
}
