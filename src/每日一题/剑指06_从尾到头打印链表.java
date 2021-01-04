package 每日一题;

import java.util.*;

/**
 *  利用递归的性质：栈，回溯
 *  参考题解：
 *  https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
 */
public class 剑指06_从尾到头打印链表 {
    private List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] ret = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }

    private void recur(ListNode head) {
        if (head == null) {
            return;
        }
        recur(head.next);
        list.add(head.val);
    }
}
