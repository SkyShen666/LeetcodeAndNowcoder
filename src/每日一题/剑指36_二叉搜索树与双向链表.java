package 每日一题;

/**
 *  参考题解
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
 */
public class 剑指36_二叉搜索树与双向链表 {
    private TreeNode head;
    private TreeNode pre;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }

        inorder(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void inorder(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inorder(curr.left);
        if (pre != null) {
            pre.right = curr;
        } else {
            head = curr;
        }
        curr.left = pre;
        pre = curr;
        inorder(curr.right);
    }
}
