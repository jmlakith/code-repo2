package amazon.nagarroInterviews;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lakith Dharmarathna
 * Date : 01/09/2022
 */
class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw...");

        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit...");
            try {
                wait();
            } catch (Exception e) {
            }
        }
        this.amount -= amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount) {
        System.out.println("going to deposit...");
        this.amount += amount;
        System.out.println("deposit completed... ");
        notify();
    }
}

class ThreadCommunication {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final Customer c = new Customer();
        new Thread(() -> c.withdraw(15000)).start();
        new Thread(() -> c.deposit(10000)).start();

    }
}
