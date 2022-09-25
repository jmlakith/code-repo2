package examples.linkedlists;

/**
 * @author Lakith Dharmarathna
 * Date : 30/06/2022
 */
public class LinkedListTest2 {
    public static void main(String[] args) {
        Node n5 = new Node("n5", null);
        Node n4 = new Node("n4", n5);
        Node n3 = new Node("n3", n4);
        Node n2 = new Node("n2", n3);
        Node n1 = new Node("n1", n2);

        Node n8 = new Node("n8", n3);
        Node n7 = new Node("n7", n8);
        Node n6 = new Node("n6", n7);

        //n1->n2->n3->n4
        //n1<-n2<-n3<-n4
      //  readNodes(n1);
        System.out.println("+++++++++++++++++++++++++++++++++++");
     //   readNodes(reverseListList(n1));

        System.out.println(getIntersectingNode(n1,n6).getValue());
    }


    private static Node reverseListList(Node startNode) {

        Node itr = startNode;
        Node temp = startNode;
        //loop
        while (itr != null) {

            if (temp == itr) {
                //let's go next node
                itr = itr.getNextNode();
                temp.setNextNode(null);
            } else {
                //we use next to iterate into next node
                Node next = itr.getNextNode();
                itr.setNextNode(temp);
                temp = itr;
                //in case next node reference is null we don't want to set itr == null
                if (next==null) {
                    break;
                }
                itr = next;
            }
        }
        return itr;
    }

    private static Node getIntersectingNode(Node node1, Node node2){

        Node itr = node1;
        while (itr != null) {
            System.out.println("val:" + itr.getValue());

            //+++++++++++++++++++++++++++++++++++
            Node itr2 = node2;
            while (itr2!=null){
                if(itr.getValue().equals(itr2.getValue())){
                    return itr;
                }
                itr2 = itr2.getNextNode();
            }
            //+++++++++++++++++++++++++++++++++++
            itr = itr.getNextNode();
        }

        return new Node();

    }


    private static void readNodes(Node n9) {
        Node itr = n9;
        while (itr != null) {
            System.out.println("val:" + itr.getValue());
            itr = itr.getNextNode();
        }
    }


}
