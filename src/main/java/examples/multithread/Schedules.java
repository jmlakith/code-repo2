package examples.multithread;

import java.util.concurrent.*;

/**
 * @author Lakith Dharmarathna
 * Date : 06/07/2022
 */
public class Schedules {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        CountDownLatch count = new CountDownLatch(5);
        service.scheduleAtFixedRate(()->{
            if (count.getCount()==0) {
                service.shutdown();
            }
            System.out.println("Hello hello nama mokakda oyage");
            count.countDown();
        },0,1, TimeUnit.SECONDS);
    }
}
