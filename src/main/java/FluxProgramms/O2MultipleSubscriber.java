package FluxProgramms;

import reactor.core.publisher.Flux;

import java.util.function.Predicate;

public class O2MultipleSubscriber {

    public static void main(String[] args) {
        Predicate<Integer> onlyEvenNoPredicate = i->i%2 == 0;
        Flux<Integer> flux = Flux.just(1,2,3,4,5);

        flux.subscribe(i-> System.out.println("sub1: "+i));

        flux.filter(onlyEvenNoPredicate).subscribe(i-> System.out.println("sub2  only even no.: "+i));
    }
}
