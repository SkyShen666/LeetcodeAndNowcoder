package 分治;

public class No_92反转链表II待解决 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        // 当m = 1时，必须搞一个head之前的dummyHead
        // 否则会出现空指针错误
        // 如[3->5], m = 1, n =2, 在第二次cur.next时会出现空指针错误
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
        }

        ListNode head2 = cur.next;
        ListNode pre = null;
        ListNode next = null;
        for (int i = m; i <= n; i++) {
            next = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = next;
        }

        cur.next.next = next;
        cur.next = pre;

        return dummyHead.next;
    }
}
