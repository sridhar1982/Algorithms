package linkedlist;

/**
 * Created by I855798 on 7/12/18.
 */
public class LinkedListMethods {

    public static void main(String[] args) {

        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);

        node1.setNextAndPrev(node2);
        node2.setNextAndPrev(node3);
        node3.setNextAndPrev(node4);

        node1.printNextAndPrev();

        System.out.println("***************");

//        LinkedNode reversed = reverseIteraive(node1);
//        System.out.println("***************");

        LinkedNode reversed = reverseRecursively(node1);
        reversed.printNextAndPrev();
    }

    public static LinkedNode reverseIteraive(LinkedNode node) {
        if (node == null || node.next == null)
            return node;
        LinkedNode current = node;
        LinkedNode prev = null;
        LinkedNode next = null;
        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current.prev=next;
            current = next;
        }
        return prev;
    }


    public static LinkedNode reverseRecursively(LinkedNode node) {
        if (node == null) {
            return node;
        }

        LinkedNode temp = node.next;
        node.next=node.prev;
        node.prev=temp;

        if (node.prev == null) {
            return node;
        }
        return reverseRecursively(node.prev);
    }


}
