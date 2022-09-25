package examples.linkedlists;

/**
 * @author Lakith Dharmarathna
 * Date : 29/06/2022
 */
public class LinkedListDriver {
    public static void main(String[] args) {
        Node n4 = new Node("n4", null);
        Node n3 = new Node("n3", n4);
        Node n2 = new Node("n2", n3);
        Node n1 = new Node("n1", n2);


        Node n5 = new Node("n5", new Node("n6", new Node("n7", new Node("n8", n2))));

        System.out.println("++++++++++++++++++++++++++++++++++++");
        readNodes(n1);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        Node n9 = reverseNodeOptimized(n1);
        readNodes(n9);

    }

    private static void readNodes(Node n9) {
        Node itr = n9;
        while (itr != null) {
            System.out.println("val:" + itr.getValue());
            itr = itr.getNextNode();
        }
    }

    static Node reverseNode(Node n) {

        Node currNode = n;
        Node prevNode = null;
        Node nextNode;
        int count = 0;
        while (currNode != null) {
            if (count == 0) {
                prevNode = currNode;
                currNode = currNode.getNextNode();
                prevNode.setNextNode(null);
                count++;
                continue;
            } else {
                nextNode = currNode.getNextNode();
                if (nextNode == null) {
                    currNode.setNextNode(prevNode);
                    break;
                }
                currNode.setNextNode(prevNode);
                prevNode = currNode;
                currNode = nextNode;
                count++;
            }
            //  System.out.println("current nodes reference:" + currNode);
        }
        return currNode;
    }

    static Node reverseNodeOptimized(Node node) {

        Node previous = null;
        Node next = null;
        Node itr = node;
        while (itr != null) {
            next = itr.nextNode;
            itr.nextNode = previous;
            previous = itr;
            itr = next;
        }

        return previous;

    }

}
