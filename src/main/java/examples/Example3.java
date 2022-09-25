package examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class Example3 {
    public static void main(String[] args) {
        List<Bucket> list = new ArrayList<>();
        list.add(new Bucket(1, 8.5f));
        list.add(new Bucket(2, 2.5f));
        list.add( new Bucket(3, 3.5f));

        list.sort((o1, o2) -> Float.compare(o1.sales, o2.sales));

        for (Bucket bucket : list) {
            System.out.println(bucket.id);
        }
    }
}

class Bucket {
    int id;
    float sales;

    public Bucket(int id, float sales) {
        this.id = id;
        this.sales = sales;
    }
}
