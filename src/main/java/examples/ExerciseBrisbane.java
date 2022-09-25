package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 15/07/2022
 */
public class ExerciseBrisbane {
    public static void main(String[] args) {
        System.out.println(newPassword("abcd", "ghi"));
    }


    public static String newPassword(String a, String b) {
        // Write your code here
        String[] arrayA = a.split("");
        String[] arrayB = b.split("");
        int length = Math.max(arrayA.length, arrayB.length);
        StringBuilder builder = new StringBuilder();

        int counterA = 0;
        int counterB = 0;
        for (int i = 0; i < length; i++) {

            if (counterA < arrayA.length && !arrayA[counterA].equals("")) {
                    builder.append(arrayA[counterA]);
                    counterA++;
            }

            if (counterB < arrayB.length && !arrayB[counterB].equals("")) {
                    builder.append(arrayB[counterB]);
                    counterB++;
            }

        }
        // System.out.println(builder.toString());
        return builder.toString();


    }

}