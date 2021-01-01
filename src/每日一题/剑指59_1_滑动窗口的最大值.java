package 每日一题;

import java.util.*;

/**
 * 单调队列: 保存滑动窗口的最大值，此单调栈是非严格单调递减的。
 * 参考题解：
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
 */
public class 剑指59_1_滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ret = new int[n - k + 1];

        // 还未形成滑动窗口
        for (int i = 0; i < k; i++) {
            // 维护单调栈
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }

        // 已形成滑动窗口
        ret[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            // 若移除滑动窗口的值为上一个滑动窗口的最大值
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            ret[i - k + 1] = deque.peekFirst();
        }

        return ret;
    }
}
