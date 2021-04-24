package A剑指Offer;
/**
 *  参考题解：
 *  https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/dong-hua-yan-shi-duo-chong-jie-fa-206-fan-zhuan-li/
 */
public class 剑指24_反转链表 {
    //迭代：头插法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
        }
        return newHead;
    }
}

//    递归
//
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;  // 注意递归出口，为head，不能为null
//        }
//
//        ListNode cur = reverseList(head.next);
//        // 递归到最后的出口返回后的操作
//        head.next.next = head;
//        head.next = null;
//
//        return cur; // 注意这里返回的数，cur返回的值是不变的。
//    }