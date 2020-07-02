package 树;

public class No_101Symmetric_Tree_Easy {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEquals(root.left, root.right);
    }

    private boolean isEquals(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return isEquals(l.left, r.right) && isEquals(l.right, r.left);
    }
}
