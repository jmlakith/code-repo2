package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 15/07/2022
 */

import java.util.Stack;

/**
 * To target nodes far from root
 */
public class DepthFirstTraversingBTree {

    private static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static void visit(Node node) {
        System.out.println(node.value);
    }

    static void traverse(Node root) {

        Stack<Node> stack = new Stack<>();

        Node current = root;

        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();

            visit(current);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        Node rr2 = new Node("Right-level3-left", null, null);
        Node rl2 = new Node("Right-level3-right", null, null);
        Node ll2 = new Node("Left-level3-left", null, null);
        Node lr2 = new Node("Left-level3-right", null, null);
        Node r1 = new Node("Right-level2", rl2, rr2);
        Node l1 = new Node("Left-level2", ll2, lr2);
        Node head = new Node("Head-level1", l1, r1);
        traverse(head);
    }


}
