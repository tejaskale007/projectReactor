package CourseUtil;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    public static final Faker FAKER = Faker.instance();
    public static Consumer<Object> onNext(){
        return o->System.out.println("Received: " + o + "\n");
    }

    public static Consumer<Throwable> onError(){
        return e-> System.out.println("Error: " + e.getMessage());
    }

    public static Runnable onComplete(){
        return ()-> System.out.println("\nCompleted");
    }

    public static Faker faker(){
        return FAKER;
    }

    public static void sleepSeconds(int seconds){
        try{
            Thread.sleep(1000+seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber(){
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name){
        return new DefaultSubscriber(name);
    }
}
