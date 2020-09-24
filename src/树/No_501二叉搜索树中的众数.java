package 树;

/**
 * 中序遍历该二叉树
 * 两步走：
 *      第一轮：查询众数个数
 *      第二轮：填充众数
 */
public class No_501二叉搜索树中的众数 {
    private TreeNode pre = null;
    private int[] result;
    // 众数个数
    private int resultCount = 0;
    // 同一个数最多的出现的次数
    private int maxCount = 0;
    private int currCount = 0;
    public int[] findMode(TreeNode root) {
        // 第一轮，查询 “众数个数”
        inOrderTraverse(root);

        // 复位
        result = new int[resultCount];
        pre = null;
        resultCount = 0;
        currCount = 0;

        // 填充众数
        inOrderTraverse(root);
        return result;
    }

    private void inOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraverse(root.left);

        // 和父节点的val是否相等
        if (pre != null && pre.val == root.val) {
            currCount++;
        } else {
            currCount = 1;
        }

        // 是否需要更新众数:
        if (currCount > maxCount) {
            maxCount = currCount;
            resultCount = 1;
        } else if (currCount == maxCount) {
            // 第一轮只查询众数个数，第二轮才填充
            if(result != null) {
                result[resultCount] = root.val;
            }
            resultCount++;
        }
        pre = root;

        inOrderTraverse(root.right);
    }
}
