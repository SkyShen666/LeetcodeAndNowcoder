package 链表;

/**
 * 参考题解:双指针法
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/dong-hua-tu-jie-leetcode-di-19-hao-wen-ti-shan-chu/
 */
public class No_19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode before = dummyHead;
        ListNode after = dummyHead;
        while (n >= 0) {
            after = after.next;
            n--;
        }

        while(after != null) {
            before = before.next;
            after = after.next;
        }

        before.next = before.next.next;
        return dummyHead.next;
    }
}
