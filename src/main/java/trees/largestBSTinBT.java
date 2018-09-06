package trees;


//https://www.programcreek.com/2014/07/leetcode-largest-bst-subtree-java/
public class largestBSTinBT {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        //left subtree
        TreeNode eleven = new TreeNode(11);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        TreeNode fourteen = new TreeNode(14);
        nine.left=eight;
        eleven.right=fourteen;
        eleven.left=nine;

        //right subtree
        TreeNode twenty = new TreeNode(20);
        TreeNode ten = new TreeNode(10);
        TreeNode thirty = new TreeNode(30);
        twenty.right=thirty;
        twenty.left=ten;
        //attach to root
        root.left=eleven;
        root.right=twenty;

        System.out.println(largestBST(root).count);

    }

    public static int largestBSTNaive(TreeNode root) {
        if (isBST(root)){
            return size(root);
        }
        else
            return Math.max(largestBSTNaive(root.left), largestBSTNaive(root.right));
    }


    public static MinMax largestBST(TreeNode root) {

        MinMax minMax = new MinMax();
        if (root==null) {
            minMax.isBST = true;
            return minMax;
        }

        MinMax left = largestBST(root.left);
        MinMax right = largestBST(root.right);

        minMax.min = Math.min(left.min, root.val);
        minMax.max = Math.max(right.max, root.val);

        if (left.isBST && right.isBST && left.max < root.val && right.min > root.val) {
            minMax.isBST=true;
            minMax.count = left.count + right.count+ 1;
        }
        else {
            minMax.isBST = false;
            minMax.count = Math.max(left.count, right.count);
        }

        return minMax;
    }

    public static boolean isBST(TreeNode root) {
        return true;
    }

    public static int size(TreeNode root) {
        if (root==null)
            return 0;
        return 1+size(root.left)+size(root.right);
    }

    public static class MinMax {
        private int min;
        private int max;
        private boolean isBST;
        private int count;

        public MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = false;
            count=0;
        }
    }
}
