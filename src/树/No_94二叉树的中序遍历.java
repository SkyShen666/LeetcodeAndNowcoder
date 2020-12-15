package 树;

import java.util.*;

public class No_94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode currNode = root;

        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            currNode = node.right;
        }

        return list;
    }
}

//  递归解法：
//
//    private List<Integer> list;
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        list = new ArrayList<>();
//        if (root == null) {
//            return list;
//        }
//
//        inOrder(root);
//
//        return list;
//    }
//
//    private void inOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        inOrder(root.left);
//        list.add(root.val);
//        inOrder(root.right);
//    }