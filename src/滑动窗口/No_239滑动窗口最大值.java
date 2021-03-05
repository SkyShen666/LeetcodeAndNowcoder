package 滑动窗口;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列
 * 与剑指offer 59题 同题
 */
public class No_239滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] ret = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }

        ret[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            ret[i - k + 1] = deque.peekFirst();
        }

        return ret;
    }
}
