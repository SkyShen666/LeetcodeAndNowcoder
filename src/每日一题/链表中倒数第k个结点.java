package 每日一题;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        ListNode p2 = head;
        while (k > 0 && p2 != null) {
            p2 = p2.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        ListNode p1 = head;
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}
