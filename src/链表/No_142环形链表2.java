package 链表;

public class No_142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(true) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
