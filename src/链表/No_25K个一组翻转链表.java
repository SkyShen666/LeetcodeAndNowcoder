package 链表;

public class No_25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode pre = start;
        ListNode end = start;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null) {
                break;
            }
            ListNode temp = end.next;
            end.next = null;
            ListNode begin = pre.next;
            pre.next = reverse(begin);
            begin.next = temp;
            pre = begin;
            end = pre;
        }
        return start.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
