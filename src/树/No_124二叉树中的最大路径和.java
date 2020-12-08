package 树;

/**
 * LeetCode 124
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点
 *
 * 时间复杂度：O(N)，其中 N是二叉树中的节点个数。对每个节点访问不超过 2次。
 *
 * 空间复杂度：O(N)，其中 N是二叉树中的节点个数。
 * 空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，最坏情况下，二叉树的高度等于二叉树中的节点个数。
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
 */
public class No_124二叉树中的最大路径和 {
    private int max;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        max = Integer.MIN_VALUE;
        dfs(root);

        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 计算当前节点左分支、右分支的最大路径值，若为负数则不选择该分支的路径。
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        // 更新历史路径最大值
        max = Math.max(max, root.val + left + right);

        // 返回给上一层经过当前节点node的单侧最大路径的值
        return root.val + Math.max(left, right);
    }
}
