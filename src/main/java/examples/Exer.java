package examples;


import javax.swing.text.html.HTMLDocument;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lakith Dharmarathna
 * Date : 15/07/2022
 */
@FunctionalInterface
interface ValidatorLogic {
    boolean validate();
}

public class Exer {

    private static String getInfo() {
        return null;
    }

    private static Integer getInfo(int x) {
        return null;
    }


    ValidatorLogic validateAge(){
        return () -> true;
    }


    public static void main(String[] args) {

       ValidatorLogic validatorLogic1 = () -> true;

        List<ValidatorLogic> validations = List.of(()-> true,()-> false);

        validations.forEach(ValidatorLogic::validate);

        System.out.println(validatorLogic1.validate());

        List.of(validatorLogic1).forEach(ValidatorLogic::validate);

        //Executor executor = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //executorService.submit()

        for(int i = 0; i < 6; i++) {
            System.out.println("************* Record added --> " + i);
            executorService.execute(() -> {
                System.out.println("Hello dude :: " + UUID.randomUUID());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }

        executorService.shutdown();


    }

}
