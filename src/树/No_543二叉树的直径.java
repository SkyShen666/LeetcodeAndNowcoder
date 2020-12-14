package 树;

public class No_543二叉树的直径 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        max = 0;
        maxDepth(root);

        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
