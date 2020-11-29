package 树;



public class No_671Second_Minimum_Node_In_a_Binary_Tree_Easy {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        // 找出候选数，默认就是子节点值，如果子节点值和root值相同，递归，在子树中寻找候选数
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }

        // 如果左右候选数都正常，返回较小值就可
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }

        // 如果候选数有-1，说明整个子树中没有可供候选的数
        if (leftVal != -1) {
            return leftVal;
        }
        //右子树正常，返回答案
        //或者右子树也没有候选数，返回-1，即rightVal
        return rightVal;
    }
}
