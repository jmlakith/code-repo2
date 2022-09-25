package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 15/07/2022
 */
public class RotateAnArrayLeft {

    void effort1() {
        int[] array = {1, 2, 3, 4};

        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < array.length; i++) {
                int temp = array[i];
                if (i + 1 < array.length) {
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+", ");
        }
    }

    static int getNewIndex(int length, int i, int shift) {

        return (length+i-shift)%length;
    }

    public static void main(String[] args) {

        new RotateAnArrayLeft().effort1();

/*        int[] array = {1, 2, 3, 4, 5};
        int[] array2 = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            array2[getNewIndex(array.length, i, 4)]=array[i];
        }

        for (int i : array2) {
            System.out.println(i);
        }*/



    }
}
