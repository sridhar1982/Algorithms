package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * print vertical order
 *        4
 *     2      6
 *  1    3 5     7
 *           8      9
 *
 * output should be [[1],[2],[4,3,5],[6,8],[7],[9]]
 *
 * https://algorithms.tutorialhorizon.com/print-the-binary-tree-in-vertical-order-path/
 **/
public class VerticalOrderPrint {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        two.left=one;
        two.right=three;
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        six.left=five;
        six.right=seven;
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        seven.right=nine;
        five.right=eight;
        root.left=two;
        root.right=six;

        System.out.println(verticalOrder(root));



    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;

        // level and list
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        LinkedList<Wrapper> queue = new LinkedList<>();

        queue.offer(new Wrapper(root, 0));


        int minLevel=0;
        int maxLevel=0;

        while(!queue.isEmpty()){
            Wrapper p = queue.poll();
            int l = p.level;

            //track min and max levels
            minLevel=Math.min(minLevel, l);
            maxLevel=Math.max(maxLevel, l);

            if(map.containsKey(l)){
                map.get(l).add(p.node.val);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(p.node.val);
                map.put(l, list);
            }

            if(p.node.left!=null){
                queue.offer(new Wrapper(p.node.left, l-1));
            }

            if(p.node.right!=null){
                queue.offer(new Wrapper(p.node.right, l+1));
            }
        }


        for(int i=minLevel; i<=maxLevel; i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }

        return result;
    }

    public static class Wrapper {
        TreeNode node;
        int level;

        public Wrapper(TreeNode node, int level) {
            this.node = node;
            this.level=level;
        }
    }
}
