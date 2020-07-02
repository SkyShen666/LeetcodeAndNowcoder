package 树;

public class No_337House_Robber_III_Medium {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }
}
