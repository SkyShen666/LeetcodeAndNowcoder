package 每日一题;

public class 剑指22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head;
        while (k > 0) {
            q = q.next;
            k--;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
