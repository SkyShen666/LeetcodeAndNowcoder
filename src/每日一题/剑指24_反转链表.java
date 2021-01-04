package 每日一题;
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

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}

//    递归
//
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode cur = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//
//        return cur;
//    }