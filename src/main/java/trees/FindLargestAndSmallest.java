package trees;

/**
 * find Kth Largest and Kth smallest from a BST
 */
public class FindLargestAndSmallest {

    public static void main(String[] args){
        //left SubTree
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3,one, two);
        //right subtree
        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7,six, eight);

        TreeNode root = new TreeNode(5, three, seven);
        System.out.println(findKthLargest(root, 3));

    }

    private static int countFromRight = 0;

    public static Integer findKthLargest(TreeNode root, int k){
        if (root==null)
            return null;

        Integer val = findKthLargest(root.right, k);
        if (val!=null)
            return val;

        if (++countFromRight==k)
            return root.val;

        return findKthLargest(root.left, k);
    }
}
