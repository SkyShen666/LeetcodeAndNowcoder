package 树;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No_144Binary_Tree_Preorder_Traversal_Medium {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            ret.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return ret;
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
