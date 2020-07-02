package 树;



public class No_671Second_Minimum_Node_In_a_Binary_Tree_Easy {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int leftValue = root.left.val;
        int rightValue = root.right.val;
        if (leftValue == root.val) {
            leftValue = findSecondMinimumValue(root.left);
        }
        if (rightValue == root.val) {
            rightValue = findSecondMinimumValue(root.right);
        }
        if (leftValue != -1 && rightValue != -1) {
            return Math.min(leftValue, rightValue);
        }
        return leftValue == -1 && rightValue == -1 ? -1 : Math.max(leftValue, rightValue);

    }

}
