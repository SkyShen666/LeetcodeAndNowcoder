package 链表;

import java.util.*;

// 参考题解：
//https://leetcode-cn.com/problems/add-two-numbers-ii/solution/javakai-fa-by-sweetiee/
public class No_445两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;

        while (carry > 0 || !stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }

        return head;
    }
}
