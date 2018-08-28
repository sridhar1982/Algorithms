package linkedlist;

/**
 *
 */
public class LinkedNode {

    public int val;
    public LinkedNode next;
    public LinkedNode prev;

    public LinkedNode(int val) {
        this.val = val;
    }

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }
    public void printNext() {
        LinkedNode current = this;
        while (current!=null) {
            System.out.print(current.val +  " ");
            current=current.next;
        }
    }
}
