package amazon.nagarroInterviews;

/**
 * @author Lakith Dharmarathna
 * Date : 31/08/2022
 */
class TestInterruptingThread3 extends Thread {

    public void run() {

        System.out.println("Started");
        try {
            System.out.println("Sleeping ...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        System.out.println("Everything is done");

    }
}
public class NedBankInterview {
/*
    public static void main(String[] args) throws InterruptedException {
        TestInterruptingThread3 t1=new TestInterruptingThread3();
        t1.start();

        Thread.sleep(2000);
        t1.interrupt();
    }
*/

        public static void main(String[] args) {
        //Thread creation-> States : New -> Active -> Wait -> Timed Waiting -> Termination
        Thread thread1 = new Thread(()-> System.out.println("I'm thread one"));
        Thread thread2 = new Thread(()-> System.out.println("I'm thread two"));
        Thread thread3 = new Thread(()-> System.out.println("I'm thread three"));

        //thread scheduler in Java selects which schedule to run based on the priority
        thread1.setPriority(1);
        //Note: After starting a thread, it can never be started again.

        //thread1.join() .. current running thread will wait and let thread1 go first <-- let thread1 finish work
        // if thread1 is currently running, other threads will wait until thread1 finishes its tasks.
        //join() method can be overloaded with a time

        thread1.start();

        //Daemon threads: when all the user threads dies, JVM terminates this thread automatically.
        //Daemon thread supports user threads
        //GC is a daemon thread <- provides background support tasks like cleaning -- low priority thread

        //ThreadGroup can be used to group threads

        //Shutdown Hook method will be hit by JVM when it received a termination signal

        //You can poke a sleeping thread using interrupt method, it will throw an exception but continue working

            //Thread-Thread communication
        //wait notify notifyAll <-- in Object class (since locks are in object class)
        //wait - Release the lock and wait
        //notify - wakes waiting thread
        //notify all - wakes up all the waiting threads on object's monitor

        //Synchronized block is more efficient than method
        // If you make any static method as synchronized, the lock will be on the class not on object.
    }
}
