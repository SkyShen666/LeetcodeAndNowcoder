package A剑指Offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
