package A剑指Offer;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class 剑指28_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isEqual(root.left, root.right);
    }

    private boolean isEqual(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }

        return isEqual(l.left, r.right) && isEqual(l.right, r.left);
    }
}
