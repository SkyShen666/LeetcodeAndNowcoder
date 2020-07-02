package 每日一题;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 平衡二叉树 {
    private boolean isBalance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalance;
    }

    private int height(TreeNode node) {
        if (node == null || !isBalance) //若非平衡二叉树直接返回
            return 0;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
