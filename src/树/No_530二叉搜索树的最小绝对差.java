package 树;

// 注意二叉搜索树，中序遍历的集合是单调递增的
public class No_530二叉搜索树的最小绝对差 {
    private int preVal;
    private int min;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("树不能为空！");
        }

        preVal = -1;
        min = Integer.MAX_VALUE;

        inorderTraverse(root);

        return min;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        if (preVal == -1) {
            preVal = root.val;
        } else {
            min = Math.min(min, root.val - preVal);
            preVal = root.val;
        }
        inorderTraverse(root.right);
    }
}
