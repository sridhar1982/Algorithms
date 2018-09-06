package linkedlist;

import java.util.Stack;

/**
 * Created by I855798 on 7/30/18.
 */
public class AddLinkedList {

    public static void main(String[] args) {

        LinkedNode node1 = getNode(99971);
        LinkedNode node2 = getNode(998);

        node1.printNext();
        node2.printNext();

        LinkedNode result = addTwoLinkedNodesWithStacks(node1, node2);
        result.printNext();

        result = addLinkedListRecursive(node1, node2);
        result.printNext();

        node1 = getNode(99971);
        node2 = getNode(998);

        result = addLinkedListIterative(node1, node2);
        result.printNext();
    }

    public static LinkedNode addLinkedListIterative(LinkedNode n1, LinkedNode n2) {
        LinkedNode r1 = reverse(n1);
        LinkedNode r2 = reverse(n2);

        int carry = 0;
        int sum = 0;
        LinkedNode prev = null;
        LinkedNode head = null;

        LinkedNode current1 = r1;
        LinkedNode current2 = r2;
        while (current1!=null || current2!=null) {

            int val1 = current1!=null ? current1.val : 0;
            int val2 = current2!=null ? current2.val : 0;
            sum = val1+val2+carry;
            carry = sum/10;
            sum = sum%10;

            LinkedNode temp = new LinkedNode(sum);

            if (head == null) {
                head = temp;
                prev = temp;
            }
            else {
                prev.next = temp;
                prev = temp;
            }

            current1 = current1!=null ? current1.next : null;
            current2 = current2!=null ? current2.next : null;
        }

        System.out.println("carry is " + carry);
        if (carry > 0) {
            LinkedNode temp = new LinkedNode(carry);
            prev.next = temp;
        }

        return reverse(head);
    }



    public static  LinkedNode addLinkedListRecursive(LinkedNode n1, LinkedNode n2){
        LinkedNode r1 = reverse(n1);
        LinkedNode r2 = reverse(n2);
        LinkedNode result = addLinkedListRecursiveHelper(r1,r2,0);
        return reverse(result);
    }

    public static LinkedNode addLinkedListRecursiveHelper(LinkedNode n1, LinkedNode n2, int carry) {

        if (n1 == null && n2 == null) {
            if (carry == 0){
                return null;
            }
            return new LinkedNode(carry);
        }

        int val1 = (n1!=null) ? n1.val : 0;
        int val2 = (n2!=null) ? n2.val : 0;

        int sum = val1+val2+carry;
        carry = sum/10;
        sum = sum%10;

        LinkedNode head = new LinkedNode(sum);

        LinkedNode node1Next = (n1 != null) ? n1.next : null;
        LinkedNode node2Next = (n2 != null) ? n2.next : null;
        head.next = addLinkedListRecursiveHelper(node1Next, node2Next, carry);
        return head;

    }

     public static LinkedNode addTwoLinkedNodesWithStacks(LinkedNode node1, LinkedNode node2) {

        Stack<LinkedNode> s1 = new Stack<>();
        Stack<LinkedNode>  s2 = new Stack<>();
         Stack<LinkedNode>  result = new Stack<>();

        LinkedNode current = node1;
        while (current!=null) {
            s1.push(current);
            current=current.next;
        }
        current = node2;
         while (current!=null) {
             s2.push(current);
             current=current.next;
         }

         int carry = 0;
         int sum = 0;

         while (!s1.isEmpty() && !s2.isEmpty()) {

             sum = s1.pop().val + s2.pop().val + carry;
             carry = sum/10;
             sum = sum%10;
             result.push(new LinkedNode(sum));
         }

         while (!s1.isEmpty()){
             sum = s1.pop().val + carry;
             carry = sum/10;
             sum = sum%10;
             result.push(new LinkedNode(sum));
         }

         while (!s2.isEmpty()){
             sum = s2.pop().val + carry;
             carry = sum/10;
             sum = sum%10;
             result.push(new LinkedNode(sum));
         }

         if (carry!=0){
             result.push(new LinkedNode(carry));
         }
         LinkedNode resultNode = null;
         LinkedNode tail = null;
         while(!result.isEmpty()){
             current = result.pop();
             if (resultNode == null) {
                 resultNode = current;
                 tail = current;
             }
             else {
                 tail.next = current;
                 tail = current;
             }
         }
         return resultNode;
     }

     public static LinkedNode getNode(int num){

        LinkedNode prev = null;
        while (num > 0){
            LinkedNode current = new LinkedNode(num%10);
            current.next = prev;
            prev=current;
            num = num/10;
        }

        return prev;
     }

     public static LinkedNode reverse(LinkedNode node){

         LinkedNode prev = null;
         LinkedNode temp = null;
         LinkedNode current = node;

         while(current!=null) {
             temp = current.next;
             current.next=prev;
             prev=current;
             current=temp;
         }

         return prev;
     }
}
