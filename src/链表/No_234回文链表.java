package 链表;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 解法：（三步走
 *      1. 找到分割点,并分割成两个链表
 *      2. 后半链表进行倒置(尾插法)
 *      3. 对两段链表进行比较
 */
public class No_234回文链表 {
    public static void main(String[] args) {

    }

    /**
     * Description:
     *  Given a singly linked list, determine if it is a palindrome.
     * Example1:
     *  Input: 1->2
     *  Output: false
     * Example2:
     *  Input: 1->2->2->1
     *  Output: true
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        cut(head, slow);
        return isEqual(head, reverse(slow));
    }

    private boolean isEqual(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        // 头插法
        while(head != null) {
            ListNode next = head.next;
            head.next = dummyHead.next;
            dummyHead.next = head;
            head = next;
        }
        return dummyHead.next;
    }

    private void cut(ListNode head, ListNode cutNode) {
        while(head.next != cutNode) {
            head = head.next;
        }
        head.next = null;
    }
}
