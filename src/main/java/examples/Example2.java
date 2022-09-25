package examples;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lakith Dharmarathna
 * Date : 06/07/2022
 */
public class Example2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int target=6;
        Set<String> result = new HashSet<>();

        for (int first : array) {
            for (int second : array) {
                if (first!=second) {
                    if (first+second==target) {
                        if (!(result.contains(first+"<>"+second) || result.contains(second+"<>"+first))) {
                            result.add(first+"<>"+second);
                        }
                    }
                }
            }
        }

        result.forEach(System.out::println);
    }
}
