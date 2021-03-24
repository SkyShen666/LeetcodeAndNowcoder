package 每日一题;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 剑指55_2平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfs(root.left);
        if (leftDepth == - 1) {
            return -1;
        }
        int rightDepth = dfs(root.right);
        if (rightDepth == -1) {
            return -1;
        }

        // 若左右子树的高度之差大于2，则返回-1，否则返回树的高度
        return Math.abs(leftDepth - rightDepth) < 2 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
