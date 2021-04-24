package A剑指Offer;

/**
 *  二叉搜索树的 中序倒序遍历
 *  利用二叉搜索树的性质
 *  中序倒序 遍历顺序： 右， 中， 左
 *  正常中序遍历二叉搜索树： 从小到大
 *  中序倒序遍历： 从大到小
 *  参考题解：
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class 剑指54_二叉搜索树的第k个结点 {
    private int ret;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorderReverse(root);

        return ret;
    }

    private void inorderReverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderReverse(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            ret = root.val;
        }
        inorderReverse(root.left);
    }
}