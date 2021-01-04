package 每日一题;

/**
 *  二叉搜索树的 中序倒序遍历
 *  利用二叉搜索树的性质
 *  中序遍历顺序： 右， 中， 左
 *  参考题解：
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class 二叉搜索树的第k个结点 {
    private int ret;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;

        dfs(root);

        return ret;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            ret = root.val;
        }
        dfs(root.left);
    }
}