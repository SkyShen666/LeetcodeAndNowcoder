package 链表;

// 参考题解：
// https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
// 1. 设入环之前有a个节点，环中有b个节点
// 2. f = 2s （快指针走过的路程是满指针的两倍）
// 3. f = s + nb (快慢指针相遇时，快指针比满指针刚好多走n圈)
// 4. 推出：s = nb (慢指针已走nb步)
// 5. 若从head节点开始走，需要走 a + nb 步能走到入环点, 此时 s 已走 nb 步，还需走 a 步即可到达入环点
// 6. 如何知道slow刚好走a步？ 只需从head节点开始和slow指针一起一步步走，相遇时即走了a步！
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
