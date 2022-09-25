package examples;

import java.util.*;

/**
 * @author Lakith Dharmarathna
 * Date : 23/06/2022
 */
public class TempExercise {

    public static void main(String[] args) {

        int[] numberArray = {3, 2, 4, 5};

      //  findSubArray(numberArray,9);
        System.out.println(shortestSubarray(numberArray,9));

    }

    private static int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }

    public static void findSubArray(int[] array, int x) {

        List<Integer> counts = new ArrayList<>();

        int sum = 0;
        int elements = 0;
        for (int i = 0; i < array.length; i++) {

            int tempSum = sum+=array[i];
            elements++;
            if (tempSum==x) {
                counts.add(elements);
                elements = 0;
                sum = 0;
                i=i-1;
            }

        }


        counts.sort(Comparator.naturalOrder());
        System.out.println(counts.get(0));

    }

}

