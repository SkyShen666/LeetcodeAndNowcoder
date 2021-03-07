package 每日一题;

/**
 * 递归分治：
 *      根据二叉搜索树后续遍历的性质（序列的最后一个元素是树的根），划分出左右子树。
 * 参考题解：
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
 */
public class 剑指33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int low, int high) {
        if (low >= high) {
            return true;
        }

        int p = low;
        while (postorder[p] < postorder[high]) p++;
        int mid = p;
        while (postorder[p] > postorder[high]) p++;

        return p == high && recur(postorder, low, mid - 1) && recur(postorder, mid, high - 1);
    }
}
