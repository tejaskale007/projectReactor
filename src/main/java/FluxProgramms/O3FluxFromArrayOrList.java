package FluxProgramms;

import CourseUtil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class O3FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a","b","c","d");

        Flux.fromIterable(stringList)
                .subscribe(Util.onNext());
    }
}
