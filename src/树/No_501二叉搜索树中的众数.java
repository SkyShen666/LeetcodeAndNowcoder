package 树;

/**
 * 中序遍历该二叉树
 * 两步走：
 *      第一轮：查询众数个数
 *      第二轮：填充众数
 */
public class No_501二叉搜索树中的众数 {
    private TreeNode pre;
    private int[] ret;
    private int modeCnt; // 众数个数
    private int maxCnt;  // 众数出现的频次
    private int currCnt; // 当前数出现的频次

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        modeCnt = 0;
        maxCnt = 0;
        currCnt = 0;

        // 第一次中序遍历：查询众数个数，与众数出现的频次
        inorderTraverse(root);

        ret = new int[modeCnt];
        modeCnt = 0;
        currCnt = 0;
        pre = null;

        // 第二次中序遍历：填充众数
        inorderTraverse(root);

        return ret;
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);

        if (pre != null && pre.val == root.val) {
            currCnt++;
        } else {
            currCnt = 1;
        }

        if (currCnt > maxCnt) {
            modeCnt = 1;
            maxCnt = currCnt;
        } else if (currCnt == maxCnt) {
            // 第一轮只查询众数个数，第二轮才填充
            if (ret != null) {
                ret[modeCnt] = root.val;
            }
            modeCnt++;
        }

        pre = root;

        inorderTraverse(root.right);
    }
}
