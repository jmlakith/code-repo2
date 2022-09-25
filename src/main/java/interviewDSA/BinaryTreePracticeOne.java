package interviewDSA;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Lakith Dharmarathna
 * Date : 24/08/2022
 */

class Node<V> {
    Node<V> left;
    Node<V> right;
    int id;
    V value;

    public Node(Node<V> left, Node<V> right, V value, int id) {
        this.left = left;
        this.right = right;
        this.value = value;
        this.id = id;
    }
}

public class BinaryTreePracticeOne {

    public static void main(String[] args) {

        Node<Integer> n0 = new Node<>(null, null, 5, 0);
        Node<Integer> n1 = new Node<>(null, n0, 10, 1);
        Node<Integer> n2 = new Node<>(null, null, 20, 2);
        Node<Integer> n3 = new Node<>(n1, n2, 30, 3);

        //  printBinaryTree(n3);

        searchBinaryTree(n3, 20);


    }

    private static void printBinaryTree(Node<Integer> node) {
        visit(node);
        if (node.right != null) {
            printBinaryTree(node.right);
        }

        if (node.left != null) {
            printBinaryTree(node.left);
        }

    }

    private static void searchBinaryTree(Node<Integer> node, Integer value) {
        if (!check(node, value)) {
            if (node.right != null) {
                searchBinaryTree(node.right, value);
            }

            if (node.left != null) {
                searchBinaryTree(node.left, value);
            }
        } else {
            System.out.println(node.id);
        }

    }

    private static boolean check(Node<Integer> node, Integer value) {
        return node.value.equals(value);
    }

    private static void visit(Node<Integer> node) {
        System.out.println(node.value);
    }
}
