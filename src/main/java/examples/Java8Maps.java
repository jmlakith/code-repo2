package examples;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 15/07/2022
 */
public class Java8Maps {
    public static void main(String[] args) {
        Map<String,String> map = Map.of("name","Lakith");

        map.keySet().stream().collect(Collectors.toList()).forEach(System.out::println);
    }
}
