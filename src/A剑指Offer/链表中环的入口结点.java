package A剑指Offer;

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
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 思路：
 *      设置快慢指针，fast和slow，fast每次移动两个结点，slow移动一个结点
 *      因为存在环，所以fast和slow必定在这个环的某个结点相交；
 *      x + y + z + y = 2 (x + y) ==> x = z
 */
public class 链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        //此时slow 与 fast 已经相遇
        // 由x + y + z + y = 2 (x + y) ==> x = z 知
        //从head和相遇点，在移动同样的结点数会在环的入口点汇合
        fast = pHead;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
