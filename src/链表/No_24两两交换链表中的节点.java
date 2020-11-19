package 链表;

// 参考题解:https://leetcode-cn.com/problems/swap-nodes-in-pairs/
// 递归做法
public class No_24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
