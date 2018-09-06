package trees;

import java.util.Stack;

/**
 * http://javabypatel.blogspot.com/2016/01/verify-preorder-sequence-in-binary-search-tree.html
 */
public class ValidatePreOrderSequence {

    public static void main(String[] args) {

        int[] validSeq = {45,25,15,35,75};
        int[] invalidSeq = {45,15,25,35,5};
        System.out.println("valid recursive " + isValidRecursive(validSeq, 0, 4, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("invalid recursive " + isValidRecursive(invalidSeq, 0, 4, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("valid isValidUsingTwoStacks "+  isValidUsingTwoStacks(validSeq));
        System.out.println("invalid isValidUsingTwoStacks "+  isValidUsingTwoStacks(invalidSeq));

    }

    public static boolean isValidRecursive(int[] preOrder, int start, int end, int min, int max) {

        if (start>=end) {
            return true;
        }

        int i;
        int root = preOrder[start];
        for (i=start;i<=end;i++) {
            if (preOrder[i] < min || preOrder[i] > max) {
                return  false;
            }
            if (preOrder[i]>root) {
                break;
            }
        }

        boolean left = isValidRecursive(preOrder, start+1, i-1,min, root);
        boolean right = isValidRecursive(preOrder, i,  end, root, max);

        return left && right;
    }

    public static boolean isValidUsingTwoStacks(int[] preOrder) {

        Stack<Integer> pre = new Stack<>();
        Stack<Integer> inOrder = new Stack<>();
        pre.push(preOrder[0]);

        for (int i = 1; i< preOrder.length; i++) {
            while (!pre.isEmpty() && pre.peek() < preOrder[i]){
                int temp = pre.pop();
                if (!inOrder.isEmpty() && inOrder.peek() > temp) {
                    return false;
                }
                    inOrder.push(temp);
                }
            pre.push(preOrder[i]);
            }
        return true;
    }
}
