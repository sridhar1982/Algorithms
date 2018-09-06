//package tree;
//
//import linkedList.LinkedNode;
//
///**
// * bt to linkedList
// */
//public class TreeToLinkedList {
//
//
//    public static LinkedNode head;
//    public static LinkedNode prev;
//    public static LinkedNode curr;
//
//    public static void main(String[] args) {
//
//    }
//
//    public static LinkedNode convert(TreeNode root) {
//
//        if (root==null)
//            return null;
//        if (root.left==null && root.right==null) {
//            return new LinkedNode(root.val);
//        }
//
//        LinkedNode p = new LinkedNode(root.val);
//        if (head == null) {
//            head = p;
//
//        }
//        head.setPrev(prev);
//        head.setNext();
//        prev = p;
//
//
//        LinkedNode node = convert(root.left);
//
//        if (node!=null) {
//            if (head == null) {
//                head = node;
//                curr = node;
//                prev = node;
//            }
//            else {
//
//            }
//        }
//
//
//    }
//
//
//}
