package 树;

// 递归：快慢指针找到中间点
// 参考题解：
// https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/jian-dan-di-gui-bi-xu-miao-dong-by-sweetiee-3/
public class No_109有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}
