package FluxProgramms;

import CourseUtil.Util;
import reactor.core.publisher.Flux;

public class O4FluxRange {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 12);

        flux.map(i -> Util.faker().name().fullName()).subscribe(Util.onNext());
    }
}
