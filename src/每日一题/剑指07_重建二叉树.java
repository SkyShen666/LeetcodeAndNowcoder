package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class 剑指07_重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < n; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, n), Arrays.copyOfRange(inorder, i + 1, n));
            }
        }

        return root;
    }
}
