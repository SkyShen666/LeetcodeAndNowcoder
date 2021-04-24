package A剑指Offer;

import java.util.*;

/**
 *  利用递归的性质：栈，回溯
 *  参考题解：
 *  https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
 */
public class 剑指06_从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();
        reverseList(head, list);
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    private void reverseList(ListNode head, List<Integer> list) {
        if (head == null) {
            return;
        }

        reverseList(head.next, list);
        list.add(head.val);
    }
}
