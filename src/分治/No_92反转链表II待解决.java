package 分治;

public class No_92反转链表II待解决 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p = newHead;
        for (int i = 1; i < m; i++) {
            p = p.next;
        }

        ListNode nextHead = p.next;
        ListNode next = null;
        ListNode pre = null;
        //头插法
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        p.next.next = next;
        p.next = pre;

        return newHead.next;
    }
}
