package 树;


import java.util.*;

public class No_144二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            // 因为是栈：一定注意right和left要颠倒
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}



//    private List<Integer> list;
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        list = new ArrayList<>();
//        preOrder(root);
//
//        return list;
//    }
//
//    private void preOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        list.add(root.val);
//        preOrder(root.left);
//        preOrder(root.right);
//    }
