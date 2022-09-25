package amazon.nagarroInterviews;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author Lakith Dharmarathna
 * Date : 01/09/2022
 */
public class CollectionApi {
    //Quick sort will be used for primitive sorts and variant of merge sort will be used for others(Timsort)
    // Collections.sort delegates to Arrays.sort
    //Quick sort problems -> dramatic worst case(n^2), not O(nlogn)
    //Treemap used red black self-balancing b tree, O(1) - O(logn)

    //Iterator  -> Collection (Collection extends Iterator ) -> List
    //ArrayList, LinkedList both are not synchronized <- TreeSet
    //Vector is synchronized, Stack is subclass of vector, and it is synchronized
    //HashSet does not allow duplicates
    //Java TreeSet class maintains ascending order,Java TreeSet class doesn't allow null elements.
    public static void main(String[] args) {


/*
        Collection<String> collection = new ArrayList<>();
        collection.add("Lakith");
        Iterator itr = collection.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
*/

        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(4);
        list.add(21);
        list.add(6);
        Collections.sort(list,Comparator.reverseOrder());

        list.forEach(System.out::println);

    }


}
