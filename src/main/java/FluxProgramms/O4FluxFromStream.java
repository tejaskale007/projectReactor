package FluxProgramms;

import CourseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class O4FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        Flux<Integer> integerFlux = Flux.fromStream(stream);

        integerFlux.subscribe(Util.onNext(),Util.onError(),Util.onComplete()); //you can't reuse stream
    }
}
