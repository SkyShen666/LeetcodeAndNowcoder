package 树;

import java.util.*;

public class No_145Binary_Tree_Postorder_Traversal_Medium {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // 注意left与right的顺序
            // 这里后续遍历并不是单纯的前序遍历的倒序
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
