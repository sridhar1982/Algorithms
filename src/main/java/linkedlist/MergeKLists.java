package linkedlist;

/**
 * merge k lists
 * https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
 */
public class MergeKLists {

    public static void main(String[] args) {

        LinkedNode first = new LinkedNode(1);
        first.next = new LinkedNode(3);
        first.next.next = new LinkedNode(5);

        LinkedNode second = new LinkedNode(2);
        second.next = new LinkedNode(4);
        second.next.next = new LinkedNode(6);

        LinkedNode i1 = new LinkedNode(1);
        i1.next = new LinkedNode(5);
        i1.next.next = new LinkedNode(9);
        i1.next.next.next = new LinkedNode(13);

        LinkedNode i2 = new LinkedNode(2);
        i2.next = new LinkedNode(6);
        i2.next.next = new LinkedNode(10);

        LinkedNode i3 = new LinkedNode(3);
        i3.next = new LinkedNode(7);
        i3.next.next = new LinkedNode(14);

        LinkedNode i4 = new LinkedNode(4);
        i4.next = new LinkedNode(8);
        i4.next.next = new LinkedNode(12);
        i4.next.next.next = new LinkedNode(15);

        LinkedNode[] input = {i1,i2,i3,i4};


        LinkedNode result = mergeTwoLists(first, second);
        LinkedNode result1 = mergeKLists(input);
        result1.printNext();

    }

    public static LinkedNode mergeKLists(LinkedNode[] input) {

        int size = input.length;
        int start = 0;
        int end = size - 1;
        while (size > 1) {
            while (start <= end) {
                input[start] = mergeTwoLists(input[start], input[end]);
                start++;
                end--;
            }
            start = 0;
            size = size / 2;
        }

        return input[0];
    }

    public static LinkedNode mergeTwoLists(LinkedNode first, LinkedNode second) {

        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        LinkedNode result = null;

        if (first.val < second.val) {
            result = first;
            result.next = mergeTwoLists(first.next, second);
        }
        else {
            result = second;
            result.next = mergeTwoLists(first, second.next);
        }

        return result;
    }
}
