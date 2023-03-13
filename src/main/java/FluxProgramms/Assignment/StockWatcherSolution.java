package FluxProgramms.Assignment;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class StockWatcherSolution {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        PricePublisher.getPrice()
                .subscribeWith(new Subscriber<Integer>() {

                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription; //storing given subscribtion
                        subscription.request(Long.MAX_VALUE);//request(no of objects we want)
                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now() + " : Price : " + price);
                        if(price > 110 || price < 90){
                            this.subscription.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });

        latch.await();
    }
}
