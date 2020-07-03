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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 计算当前节点左分支、右分支的最大路径值，若为负数则不选择该分支的路径。
        int leftMax = Math.max(dfs(node.left), 0);
        int rightMax = Math.max(dfs(node.right), 0);

        // 计算经过当前节点node的最大路径的值
        int curMax = node.val + leftMax + rightMax;

        // 更新历史路径最大值
        maxSum = Math.max(curMax, maxSum);

        // 返回给上一层经过当前节点node的单侧最大路径的值
        return node.val + Math.max(leftMax, rightMax);
    }
}
