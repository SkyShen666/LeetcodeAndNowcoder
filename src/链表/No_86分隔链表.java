package 链表;

// 两个链表，然后拼接上
public class No_86分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode p1 = dummyHead1;
        ListNode p2 = dummyHead2;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = dummyHead2.next;

        return dummyHead1.next;
    }
}
