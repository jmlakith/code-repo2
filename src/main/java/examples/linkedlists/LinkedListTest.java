package examples.linkedlists;

import java.util.LinkedList;

/**
 * @author Lakith Dharmarathna
 * Date : 29/06/2022
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("USD");
        list.add("LKR");
        list.add("INR");

        System.out.println(list.removeFirst());
    }
}
