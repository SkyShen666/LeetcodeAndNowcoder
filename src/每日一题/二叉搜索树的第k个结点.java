package 每日一题;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class 二叉搜索树的第k个结点 {
    private int cnt = 0;
    private TreeNode ret;

    TreeNode KthNode(TreeNode pRoot, int k) {
        InTraversal(pRoot, k);
        return ret;

    }

    private void InTraversal(TreeNode pRoot, int k) {
        if (pRoot == null || cnt >= k)
            return;
        InTraversal(pRoot.left, k);
        cnt++;
        if (cnt == k)
            ret = pRoot;
        InTraversal(pRoot.right, k);
    }
}