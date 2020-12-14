package 树;

import java.util.*;
// 参考题解
// https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/a-li-mian-shi-ti-zhi-yong-zhan-qu-zuo-er-cha-shu-d/
// null 表示父节点的左右子节点都已遍历完
public class No_145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node == null) {
                stack.pop();
                list.add(stack.peek().val);
                stack.pop();
                continue;
            }
            stack.push(null);
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

//    栈
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//
//        Deque<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//
//        while (stack.size() > 0) {
//            TreeNode node = stack.pop();
//            res.add(node.val);
//            // 注意left与right的顺序
//            // 这里后续遍历并不是单纯的前序遍历的倒序
//            if (node.left != null) {
//                stack.push(node.left);
//            }
//            if (node.right != null) {
//                stack.push(node.right);
//            }
//        }
//        Collections.reverse(res);
//        return res;
//    }



//   递归解法：
//
//    private List<Integer> list;
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        list = new ArrayList<>();
//
//        postOrder(root);
//
//        return list;
//    }
//
//    private void postOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        postOrder(root.left);
//        postOrder(root.right);
//        list.add(root.val);
//    }