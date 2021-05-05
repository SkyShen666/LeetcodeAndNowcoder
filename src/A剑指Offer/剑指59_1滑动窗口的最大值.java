package A剑指Offer;

import java.util.*;

/**
 * 单调队列: 保存滑动窗口的最大值，此单调队列是非严格单调递减的。
 * 参考题解：
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-i-hua-dong-chuang-kou-de-zui-da-1-6/
 */
public class 剑指59_1滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] ret = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // 1. 还未形成滑动窗口
        for (int i = 0; i < k; i++) {
            // 维护单调队列（队首为最大值）
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }

        // 2. 已形成滑动窗口
        // 添加第一个窗口的最大值
        ret[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            // 若移除滑动窗口的值为上一个滑动窗口的最大值
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            // 维护单调队列
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            // 将滑动窗口最大值添加至数组中
            ret[i - k + 1] = deque.peekFirst();
        }

        return ret;
    }
}