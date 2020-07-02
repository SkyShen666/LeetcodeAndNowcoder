package 树;

import java.util.LinkedList;
import java.util.Queue;

public class No_538Convert_BST_to_Greater_Tree_Easy {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    /**
     * 先遍历右子树
     * @param node
     */
    private void traversal(TreeNode node) {
        if (node == null) {
            return ;
        }
        traversal(node.right);
        sum += node.val;
        node.val = sum;
        traversal(node.left);
    }
}
