package linkedlist;

public class LinkedNode {

    int val;
    public LinkedNode next;
    public LinkedNode prev;

    public LinkedNode(int val) {
        this.val = val;
    }

    public LinkedNode(int val, LinkedNode next, LinkedNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public void setNextAndPrev(LinkedNode node1) {
        this.next = node1;
        node1.prev=this;
    }

    public void printNextAndPrev(){
        LinkedNode current = this;

        while (current!=null) {
            System.out.println("prev -> " + current.prev + " val -> " + current + " next -> " + current.next);
            current = current.next;
        }
    }

    public void printNext() {

        LinkedNode current = this;

        while (current!=null) {
            System.out.print(current + ",");
            current = current.next;
        }
        System.out.println();
    }

    public String toString() {
        return String.valueOf(val);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode prev) {
        this.prev = prev;
    }
}
