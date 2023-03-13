package FluxProgramms;

import CourseUtil.Util;
import FluxProgramms.helper.NameProducer;
import reactor.core.publisher.Flux;

public class FluxCreateRefactoring {
    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .subscribeWith(Util.subscriber());

        nameProducer.produce();
    }
}
