package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by I855798 on 7/12/18.
 */
public class BinaryTreeMethods {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        TreeNode left3 = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        right1.left = new TreeNode(11);
        left2.right = seven;
        seven.left = new TreeNode(8);
        seven.right = new TreeNode(13);

        root.left=left1;
        root.right=right1;
        left1.left = left2;
        left2.left = left3;
        System.out.println("height of tree is " + height(root));
//        preOrderRecursive(root);
//        System.out.println("*****");
//        preOrderIterative(root);
        System.out.println("*****");
        postOrderRecursive(root);
        System.out.println("*****");
        postOrderIterative(root);
        System.out.println("*****");
//        inorderRecursive(root);
//        System.out.println("*****");
//        inorderIterative(root);
//        System.out.println("*****");
//        levelOrder(root);

        printSpiralRecursive(root);

    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void preOrderRecursive(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    public static void preOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode tn  = s.pop();
            System.out.println(tn.val);
            if (tn.right!=null)
                s.push(tn.right);
            if(tn.left!=null)
                s.push(tn.left);
        }
    }

    public static void postOrderRecursive(TreeNode root) {
        if (root!=null) {
            postOrderRecursive(root.left);
            postOrderRecursive(root.right);
            System.out.println(root.val);
        }
    }

    public static void postOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.add(root);

        while(!s1.isEmpty()) {
            TreeNode node = s1.pop();
            if (node.left!=null) {
                s1.push(node.left);
            }
            if (node.right!=null) {
                s1.push(node.right);
            }
            s2.push(node);
        }

        while(!s2.isEmpty()) {
            System.out.println(s2.pop().val);
        }
     }

     public static void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.val);
            inorderRecursive(root.right);
        }
     }

    public static void inorderIterative(TreeNode root) {
        if (root == null)
            return;
        TreeNode current = root;
        Stack<TreeNode> s = new Stack<>();

        while(current!=null || !s.isEmpty()) {

            while (current!=null) {
                s.push(current);
                current=current.left;
            }
            current = s.pop();
            System.out.println(current.val);
            current = current.right;
        }
    }

    //breadth first
    private static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left!=null) {
                q.add(temp.left);
            }
            if (temp.right!=null) {
                q.add(temp.right);
            }
            System.out.println(temp.val);
        }
    }

    private static void printSpiralRecursive(TreeNode root) {

        if (root == null) {
            return;
        }

        int height = height(root);
        boolean isLeft = false;
        for (int i = 1; i<=height; i++) {
            printGivenLevel(root, i, isLeft);
            isLeft = !isLeft;
        }
    }

    private static void printGivenLevel(TreeNode root, int level, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.val);
            return;
        }
        if (isLeft) {
            printGivenLevel(root.left, level-1, isLeft);
            printGivenLevel(root.right, level-1, isLeft);
        }
        else {
            printGivenLevel(root.right, level-1, isLeft);
            printGivenLevel(root.left, level-1, isLeft);
        }
    }


}
