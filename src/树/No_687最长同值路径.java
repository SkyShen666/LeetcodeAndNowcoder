package 树;

// 与另一题题解相同：124. 二叉树中的最大路径和
// 相似题：236 二叉树的最近公共祖先
// 都是需要后续遍历的题目
// 参考题解：
// https://leetcode-cn.com/problems/longest-univalue-path/solution/687-by-ikaruga/
public class No_687最长同值路径 {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        max = 0;
        dfs(root);

        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath =  (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        int rightPath = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        max = Math.max(max, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }
}
