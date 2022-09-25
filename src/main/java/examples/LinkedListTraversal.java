package examples;

import examples.linkedlists.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Lakith Dharmarathna
 * Date : 15/07/2022
 */
public class LinkedListTraversal {

    public static void main(String[] args) {
        Node n4 = new Node("n4", null);
        Node n3 = new Node("n3", n4);
        Node n2 = new Node("n2", n3);
        Node n1 = new Node("n1", n2);


        readNodes(n1);
        System.out.println("*******************************************");
        readNodes(reverseSetupNodes(n1));
    }

    static void readNodes(Node n) {
        if (n != null) {
            System.out.println(n.getValue());
            readNodes(n.getNextNode());
        }
    }

    static void reverseNodes(Node n) {
        Stack<Node> stack = new Stack<>();

        Node currentNode = n;

        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getNextNode();
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getValue());
        }

    }

    static Node reverseSetupNodes(Node n) {
        Stack<Node> stack = new Stack<>();

        Node currentNode = n;

        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getNextNode();
        }

        List<Node> list = new ArrayList<>();
        Node next = stack.pop();
        while (!stack.isEmpty()) {
            next.setNextNode(stack.peek());
            list.add(next);
            next = stack.pop();

        }
        next.setNextNode(null);

        return list.get(0);

    }


}
