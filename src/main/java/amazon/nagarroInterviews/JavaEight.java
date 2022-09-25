package amazon.nagarroInterviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 26/07/2022
 */
public class JavaEight {
    public static void main(String[] args) {
        List<String> list = List.of("123","abc");
      //list.stream().flatMap(y-> Arrays.stream(y.split("")).sequential()).filter(x-> Pattern.compile("([a-z])").matcher(x).find()).map(y->"char:"+y).parallel().forEach(System.out::println);
       // System.out.println(list.stream().flatMap(y-> Arrays.stream(y.split("")).sequential()).map(y->"char:"+y).collect(Collectors.joining(", ")));

        list.parallelStream().forEach(System.out::println);
    }
}
