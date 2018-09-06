package trees;


import java.util.ArrayList;
import java.util.List;

/**
 *
 *       8
 *    5     3
 *  -2  6   9  11
 *
 */

public class SumOfTreeNodes {

    public static void main(String[] args){

        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node10 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        TreeNode node11 = new TreeNode(11);

        node8.left = node5;
        node8.right = node10;
        node5.left = node2;
        node5.right = node6;
        node10.left = node9;
        node10.right = node11;

        //sumOnAllPaths(node8, new ArrayList<>(), 0);
        pathSumK(node8, 11, new ArrayList<>(), 0);

       CustomWrapper result =  givenSumTree(node8, 16);
       System.out.println(result.result.val);
       System.out.println(result.found);


    }

    public static void sumOnAllPaths(TreeNode root, List<Integer> nodes, int sumSoFar){
        if (root == null){
            return;
        }
        int sum = sumSoFar;
        nodes.add(root.val);
        sum+=root.val;

        if (root.left==null && root.right==null) {
            printPaths(nodes, sum);
        }

        sumOnAllPaths(root.left, nodes,sum);
        sumOnAllPaths(root.right, nodes, sum);

        nodes.remove(nodes.size()-1);


    }

    public static void pathSumK(TreeNode root, int k, List<Integer> nodes, int sum){

        if (root==null)
            return;

        int sumSoFar = sum;
        sumSoFar+=root.val;
        nodes.add(root.val);

        if (sumSoFar == k){
            printPaths(nodes, sumSoFar);
        }

        pathSumK(root.left, k, nodes, sumSoFar);
        pathSumK(root.right, k, nodes, sumSoFar);

        nodes.remove(nodes.size()-1);

    }

    public static CustomWrapper givenSumTree(TreeNode root, int sum) {

        CustomWrapper wrapper = new CustomWrapper();

        if (root==null) {
            return wrapper;
        }

        CustomWrapper leftW = givenSumTree(root.left, sum);
        CustomWrapper rightW = givenSumTree(root.right, sum);

        if (leftW.found) {
            return leftW;
        }
        else if (rightW.found) {
            return rightW;
        }
        else {
            int temp = leftW.count + rightW.count + root.val;
            if (temp == sum) {
                wrapper.found = true;
                wrapper.result = root;
            }
            wrapper.count = temp;
        }
        return wrapper;
    }

    public static void printPaths(List<Integer> nodes, int sum) {
        System.out.println("sum " + sum + "; list " + nodes);
    }

    public static class CustomWrapper {
        private int count;
        private boolean found;
        private TreeNode result;
    }
}
