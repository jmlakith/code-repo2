package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 27/08/2022
 */

class AllPermutation
{

    private final int Arr[];

    private int Indexes[];

    private int Increase;

    public AllPermutation(int arr[])
    {
        this.Arr = arr;
        this.Increase = -1;
        this.Indexes = new int[this.Arr.length];
    }


    public void GetFirst()
    {

        this.Indexes = new int[this.Arr.length];

        for (int i = 0; i < Indexes.length; ++i)
        {
            this.Indexes[i] = i;
        }

        this.Increase = 0;

        this.Output();
    }

    public boolean HasNext()
    {

        return this.Increase != (this.Indexes.length - 1);
    }


    public void GetNext()
    {


        if (this.Increase == 0)
        {


            this.Swap(this.Increase, this.Increase + 1);

            // Update Increase
            this.Increase += 1;
            while (this.Increase < this.Indexes.length - 1
                    && this.Indexes[this.Increase]
                    > this.Indexes[this.Increase + 1])
            {
                ++this.Increase;
            }
        }
        else
        {

            if (this.Indexes[this.Increase + 1] > this.Indexes[0])
            {
                this.Swap(this.Increase + 1, 0);
            }
            else
            {
                int start = 0;
                int end = this.Increase;
                int mid = (start + end) / 2;
                int tVal = this.Indexes[this.Increase + 1];
                while (!(this.Indexes[mid]<tVal&& this.Indexes[mid - 1]> tVal))
                {
                    if (this.Indexes[mid] < tVal)
                    {
                        end = mid - 1;
                    }
                    else
                    {
                        start = mid + 1;
                    }
                    mid = (start + end) / 2;
                }

                this.Swap(this.Increase + 1, mid);
            }

            for (int i = 0; i <= this.Increase / 2; ++i)
            {
                this.Swap(i, this.Increase - i);
            }

            this.Increase = 0;
        }
        this.Output();
    }

    // Function to output the input array
    private void Output()
    {
        for (int i = 0; i < this.Indexes.length; ++i)
        {

            // Indexes of the input array
            // are at the Indexes array
            System.out.print(this.Arr[this.Indexes[i]]);
            System.out.print(" ");
        }
        System.out.println();
    }

    // Swap two values in the Indexes array
    private void Swap(int p, int q)
    {
        int tmp = this.Indexes[p];
        this.Indexes[p] = this.Indexes[q];
        this.Indexes[q] = tmp;
    }
}
public class Solution {

  /*  static int bubbleSort(int[] arr, int[] sortedArray) {
        int n = arr.length;
        int temp = 0;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swaps++;
                    if (compareArrays(arr, sortedArray)) {
                        break;
                    }
                }

            }
        }

        return swaps;
    }

    private static boolean compareArrays(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int getMinMoves(List<Integer> plates) {
        // Write your code here
        List<Integer> expected = new ArrayList<>();
        expected.addAll(plates);
        Collections.sort(expected);

        return bubble_Sort(convertIntegers(plates), convertIntegers(expected));

    }

    public static int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    static int bubble_Sort(int array[], int[] sortedArray) {
        int size = array.length;
        int swaps = 0;
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
// To sort in ascending order, change < to > in this line.
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                    if (compareArrays(array, sortedArray)) {
                        break;
                    }
                }

        return swaps;
    }*/

    //**********************




    public static void main(String[] args) {


       // System.out.println(getMinMoves(List.of(6,1,3,4,2)));


        int[] arr = { 0, 1, 2 };

        AllPermutation perm = new AllPermutation(arr);
        perm.GetFirst();
        while (perm.HasNext())
        {
            perm.GetNext();
        }
    }

}
