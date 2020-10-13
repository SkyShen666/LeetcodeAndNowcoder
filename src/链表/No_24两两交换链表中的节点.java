package 链表;

public class No_24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        ListNode q = head.next;

        head = q;
        while (true) {
            ListNode temp = q.next;
            q.next = pre.next;
            pre.next = q;
            p.next = temp;

            pre = p;
            p = temp;
            if (p == null || p.next == null) {
                break;
            }
            q = p.next;
        }
        return head;
    }
}
