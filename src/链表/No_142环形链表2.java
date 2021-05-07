package 链表;

// 参考题解：
// https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
// 1. 设：入环之前有a个节点，环中有b个节点
// 2. 设：fast = 2 * slow（快指针走过的路程是满指针的两倍）
// 3. 则fast与slow相遇时走过的路程：fast = slow + n * b (快慢指针相遇时，快指针比慢指针刚好多走n圈)
// 4. 推出：slow = n * b (慢指针已走 n * b 步)
// 5. 若从 head 节点开始走，需要走 a + n * b 步能走到入环点, 此时 slow 已走 n * b 步，**还需走 a 步即可到达入环点！！！**
// 6. 如何知道 slow 刚好走 a 步？ fast指针（此时fast的速度变成和slow速度相同）只需从 head 节点开始和 slow 指针一起一步步走，相遇时即走了a步！
public class No_142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // 让fast和slow两者相遇
        ListNode slow = head;
        ListNode fast = head;
        while(true) {
            if (fast.next == null || fast.next.next == null) { // 注意判断不成环的情况
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 若fast和slow相遇
                break;
            }
        }

        // fast指针从 head 节点开始和 slow 指针一起一步步走，相遇时即走了a步！
        // 此时fast的速度变成和slow速度相同
        fast = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
