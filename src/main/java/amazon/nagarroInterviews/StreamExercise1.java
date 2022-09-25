package amazon.nagarroInterviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 01/09/2022
 */
class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class StreamExercise1 {
    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));

        // productsList.stream().filter(x->x.price>25000).sorted(Comparator.comparing(p -> p.price)).map(x->x.name).flatMap(s-> Arrays.stream(s.split(""))).collect(Collectors.toList()).forEach(System.out::println);

       /* float sum = productsList.stream().map(val -> val.price).reduce(0.0f, (acc, price) -> acc + price);
        System.out.println(sum);*/

       /* float min = productsList.stream().map(val -> val.price).min(Float::compareTo).get();
        System.out.println(min);
*/
        Arrays.stream("A,B,B,C,D".split(",")).collect(Collectors.toSet()).forEach(System.out::println);

    }

}
