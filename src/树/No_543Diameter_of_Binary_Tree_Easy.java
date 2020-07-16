package 树;

public class No_543Diameter_of_Binary_Tree_Easy {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        diameter = Math.max(diameter,leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
