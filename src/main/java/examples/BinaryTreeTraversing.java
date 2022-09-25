package examples;

/**
 * @author Lakith Dharmarathna
 * Date : 07/07/2022
 */
public class BinaryTreeTraversing {

    Node n1 = new Node(new Node(null,new Node(null,null,"12"),"40"),new Node(null,new Node(null,null,"10"),"30"),"20");

}

class Node {
    Node left;
    Node right;
    String value;

    public Node(Node left, Node right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

