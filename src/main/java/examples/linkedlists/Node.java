package examples.linkedlists;

/**
 * @author Lakith Dharmarathna
 * Date : 29/06/2022
 */
public class Node {
    public String value;
    public Node nextNode;

    public Node() {
    }

    public Node(String value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
