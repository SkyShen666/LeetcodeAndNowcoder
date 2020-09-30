package 树;


import java.util.*;

public class No_144Binary_Tree_Preorder_Traversal_Medium {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(stack.size() > 0) {
            TreeNode node = stack.pop();
            res.add(node.val);
            // 因为是栈：一定注意right和left要颠倒
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }



/*    private List<Integer> preorder = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return preorder;
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }*/
}
