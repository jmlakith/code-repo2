package mentors;

/**
 * @author Lakith Dharmarathna
 * Date : 30/08/2022
 */
public class Sorting {
    public static void main(String[] args) {

        int[]arry={47,84,75,21,14,14,79};

        System.out.print("\nArray Before sort: ");
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i]+" ");
        }
        System.out.print("\nArray After  sort: ");
        sortArray(arry);
        for (int i = 0; i < arry.length; i++) {
            System.out.print(arry[i]+" ");
        }

        System.out.println("");

        //q1.1 check median number
        System.out.println("\nMedian Number: "+median(arry));

        //q1.2 check highest value
        System.out.print("Highest Value: ");
        highestValue(arry);

        //q1.3 check mode value
        System.out.println("Mode  Value  : "+mode(arry));

        //q2 check prime numbers
        System.out.print("Prime Numbers: ");
        isPrime(arry);

        System.out.println("\n ");
    }

    static void sortArray(int[]arry){
        int newa = 0;
        for (int i = 0; i < arry.length; i++) {
            for (int j = 1; j < (arry.length-i); j++) {
                if (arry[j-1]>arry[j]) {
                    //change j & j+1
                    newa = arry[j-1];
                    arry[j-1] = arry[j];
                    arry[j] = newa;
                }
            }
        }
    }

    static int median(int[]arry) {
        if (arry.length%2==1) {
            return(arry[(arry.length+1)/2-1]);
        } else {
            return((arry[arry.length/2-1]+arry[arry.length/2])/2);
        }
    }

    static void highestValue(int[]arry) {
        int max = arry[0];
        //Loop through the array
        for (int i = 0; i < arry.length; i++) {
            //Compare elements of array with max
            if(arry[i] > max)
                max = arry[i];
        }
        System.out.println(max);
    }

    static int mode(int[]arry) {
        int maxCount =0, maxValue = 0;
        for (int i = 0; i < arry.length; i++) {
            int count = 0;
            for (int j = 0; j < arry.length; j++) {
                if (arry[i]==arry[j]) {
                    count++;
                }
            }
            if (count>maxCount) {
                maxCount = count;
                maxValue = arry[i];
            }
        }
        return maxValue;
    }

    static void isPrime(int[]arry){
        //loop through the numbers one by one
        for(int i=0; i<arry.length; i++){
            boolean checkPrime = true;

            //check to see if the numbers are prime
            for (int j=2; j<arry[i]; j++){
                if(arry[i]%j==0){
                    checkPrime = false;
                    break;
                    //if not break j=3,4,5,6
                }
            }
            //print the number
            if(checkPrime)
                System.out.print(arry[i]+" ");
        }
    }
}
