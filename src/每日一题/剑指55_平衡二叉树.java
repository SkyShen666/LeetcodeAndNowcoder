package 每日一题;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 剑指55_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }

        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
