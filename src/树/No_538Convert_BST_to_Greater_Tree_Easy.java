package 树;

import java.util.LinkedList;
import java.util.Queue;

public class No_538Convert_BST_to_Greater_Tree_Easy {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
