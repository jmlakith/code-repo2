package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class SecondLargest {
    public static void main(String[] args) {
        int[] numSeries = {100,500,2,5,6,3,9,20,80};
        int largest=0;
        int secondLargest=0;

        for (int num : numSeries) {

            if(num>largest){
                secondLargest = largest;
                largest = num;
            }else if (num>secondLargest){
                secondLargest = num;
            }
        }
        System.out.println(secondLargest);
    }
}
