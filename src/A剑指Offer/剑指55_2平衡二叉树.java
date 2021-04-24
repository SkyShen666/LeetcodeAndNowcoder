package A剑指Offer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 剑指55_2平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) == -1 ? false : true;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = maxDepth(node.right);
        if (rightDepth == -1) {
            return -1;
        }
        // 若左右子树的高度之差大于2，则返回-1，否则返回树的高度
        return Math.abs(leftDepth - rightDepth) > 1 ? -1 : Math.max(leftDepth, rightDepth) + 1;
    }
}
