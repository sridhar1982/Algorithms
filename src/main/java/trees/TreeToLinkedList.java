package trees;

/**
 *       8
 *    5     10
 *  2  6   9  11
 *
 *  linkedList should be 2 -> 5-> 6 -> 8- > 9 -> 10 -> 11
 *
 *  easier approach would be to add TreeNodes to Queue as we do inorder traversal
 *  once done, remove elements from queue and establish links
 *
 */
public class TreeToLinkedList {

    public static void main(String[] args){

        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node10 = new TreeNode(10);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);

        node8.left = node5;
        node8.right = node10;
        node5.left = node2;
        node5.right = node6;
        node10.left = node9;
        node10.right = node11;

        TreeNode result = convertToLinkedList(node8);
        TreeNode temp = result;
        TreeNode temp2 = result;

        //temp points the leftmost node
        while (temp.left!=null) {
            temp = temp.left;
        }

        //temp2 points to rightmost node
        while (temp2.right!=null) {
            temp2 = temp2.right;
        }

        System.out.println("printing from left to right");
        //print the tree from left to right
        while (temp!=null) {
            System.out.print(temp.val + "->");
            temp = temp.right;
        }
        System.out.println();
        System.out.println("printing from right to left");
        //print the tree from right to left
        while (temp2!=null) {
            System.out.print(temp2.val + "->");
            temp2 = temp2.left;
        }



    }

    public static TreeNode convertToLinkedList(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode leftList = convertToLinkedList(root.left);
        TreeNode rightList = convertToLinkedList(root.right);

        while (leftList!=null && leftList.right!= null) {
            leftList = leftList.right;
        }

        while (rightList!=null && rightList.left!=null) {
            rightList = rightList.left;
        }

        root.left = leftList;
        if (leftList != null){
            leftList.right = root;
        }
        root.right=rightList;
        if (rightList!=null) {
            rightList.left = root;
        }
        return root;
    }




}
