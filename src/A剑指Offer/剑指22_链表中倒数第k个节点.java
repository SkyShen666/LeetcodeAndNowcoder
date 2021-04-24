package A剑指Offer;

public class 剑指22_链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastHead = head;
        while (k > 0) {
            k--;
            fastHead = fastHead.next;
        }
        while (fastHead != null) {
            fastHead = fastHead.next;
            head = head.next;
        }

        return head;
    }
}
