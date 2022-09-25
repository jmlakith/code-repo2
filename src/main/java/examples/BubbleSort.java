package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {234,2,6,8,9,10};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array.length-1; j++) {
                int temp;
                if (array[j]>array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }
}
