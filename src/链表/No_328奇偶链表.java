package 链表;

public class No_328奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode curEven = even;
        // 奇数节点
        while (odd.next != null && odd.next.next != null) {
            odd.next = curEven.next;
            odd = curEven.next;
            curEven.next = odd.next;
            curEven = odd.next;
        }
        odd.next = even;
        return head;
    }
}
