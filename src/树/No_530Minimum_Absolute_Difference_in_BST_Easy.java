package 树;

import java.util.ArrayList;
import java.util.List;

public class No_530Minimum_Absolute_Difference_in_BST_Easy {
    private int preValue;
    private int min;

    public int getMinimumDifference(TreeNode root) {
        preValue = -1;
        min = Integer.MAX_VALUE;
        // 二叉搜索树，中序遍历的集合是单调递增的
        inorderTraverse(root);
        return min;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        if (preValue == -1) {
            preValue = root.val;
        } else {
            min = min > (root.val - preValue) ? (root.val - preValue) : min;
            preValue = root.val;
        }
        inorderTraverse(root.right);
    }
}
