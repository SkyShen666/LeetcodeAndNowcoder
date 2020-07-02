package 树;

public class No_404Sum_of_Left_Leaves_Easy {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (isLeave(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeave(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }
}
