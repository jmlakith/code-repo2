package hackeranktest;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lakith Dharmarathna
 * Date : 26/08/2022
 */
public class Anagrams1 {

    public static void isPrime(int[] arry) {
        //loop through the numbers one by one
        for (int i = 0; i < arry.length; i++) {
            boolean checkPrime = true;

            //check to see if the numbers are prime
            for (int j = 2; j < arry[i]; j++) {
                if (arry[i] % j == 0) {
                    checkPrime = false;
                    break;
                    //if not break j=3,4,5,6
                }
            }
            //print the number
            if (checkPrime)
                System.out.print(arry[i] + " ");
        }
    }

    static void sortArray(int[] arry) {
        int newa = 0;
        for (int i = 0; i < arry.length; i++) {
            for (int j = 1; j < (arry.length - i); j++) {
                if (arry[j - 1] > arry[j]) {
                    //change j & j+1
                    newa = arry[j - 1];
                    arry[j - 1] = arry[j];
                    arry[j] = newa;
                }
            }
        }
    }

    public static void main(String[] args) {

        //isPrime(new int[]{12,7,5,13,20});
        int[] array = new int[]{12, 7, 5, 13, 20};
        sortArray(array);

        for (int i : array) {
            System.out.println(i);
        }

    }


}
