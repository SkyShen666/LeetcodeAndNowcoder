package 树;

// 树形dp
// 树的后续遍历
// 参考题解:
// https://leetcode-cn.com/problems/house-robber-iii/solution/shu-xing-dp-ru-men-wen-ti-by-liweiwei1419/
public class No_337打家劫舍3 {
    public int rob(TreeNode root) {
        int[] ret = dfs(root);

        return Math.max(ret[0], ret[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 后续遍历
        // 分类讨论的标准是：当前结点偷或者不偷
        // 由于需要后序遍历，所以先计算左右子结点，然后计算当前结点的状态值
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // dp[0]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点不偷
        // dp[1]：以当前 node 为根结点的子树能够偷取的最大价值，规定 node 结点偷
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];

        return dp;
    }
}

// 暴力递归
//
//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int val1 = root.val;
//        if (root.left != null) {
//            val1 += rob(root.left.left) + rob(root.left.right);
//        }
//        if (root.right != null) {
//            val1 += rob(root.right.left) + rob(root.right.right);
//        }
//        int val2 = rob(root.left) + rob(root.right);
//        return Math.max(val1, val2);
//    }
//