package interviewDSA;

/**
 * @author Lakith Dharmarathna
 * Date : 23/08/2022
 */

class Temp {

    public static void main(String[] args) {

        int [][] inputArray = new int[10][10];
        //init array with zeros
        for (int j = 0; j < inputArray.length; j++) {
            for (int i = 0; i < inputArray[0].length; i++) {
                inputArray[i][j] = j;
            }
        }

        for (int[] ints : inputArray) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }


    }
}