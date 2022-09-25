package examples.linkedlists;

/**
 * @author Lakith Dharmarathna
 * Date : 01/09/2022
 */
public class TRyLinkedLists {
    public static void main(String[] args) {
        Node n4 = new Node("n4", null);
        Node n3 = new Node("n3", n4);
        Node n2 = new Node("n2", n3);
        Node n1 = new Node("n1", n2);
        Node n0 = new Node("n0", n1);

        readNodesNotRecurr(addNodeToBack(n1, n0));

        //readNodes(reverseLinkedLists(n1));

        //readNodes(deleteNode(n1,n4));
    }

    static void readNodes(Node n) {
        System.out.println(n.getValue());
        if (n.getNextNode() != null) {
            readNodes(n.getNextNode());
        }
    }

    static void readNodesNotRecurr(Node n) {
        Node initNode = n;
        while (initNode != null) {
            System.out.println(initNode.getValue());
            initNode = initNode.getNextNode();
        }
    }


    static Node deleteNode(Node n, Node delete) {
        Node initNode = n;
        Node prev = null;
        while (initNode != null) {
            if (delete.value.equals(initNode.value)) {
                if (prev != null) {
                    prev.nextNode = initNode.nextNode;
                } else {
                    n = initNode.nextNode;
                }
            }
            prev = initNode;
            initNode = initNode.getNextNode();
        }

        return n;
    }

    static Node addNodeToFront(Node n, Node newNode) {
        newNode.nextNode = n;
        return newNode;
    }

    static Node addNodeToBack(Node n, Node newNode) {
        Node itr = n;
        Node prev = n;
        while (itr != null) {
            prev = itr;
            itr = itr.nextNode;
        }
        prev.nextNode = newNode;
        newNode.nextNode = null;

        return n;
    }

    static Node reverseLinkedLists(Node n) {
        Node current = n;
        Node next = null;
        Node prev = null;

        while (current != null) {
            next = current.getNextNode();
            current.nextNode = prev;
            prev = current;

            current = next;
        }

        return prev;

    }

    static Node reverseTwo(Node n) {

        Node current = n;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.nextNode;
            current.nextNode = previous;
            previous = current;

            current = next;
        }

        return previous;

    }

}
