package 每日一题;

import java.util.*;

/**
 *  滑动窗口
 *  参考题解：
 *  https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 */
public class 和为S的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> ret = new LinkedList<>();

        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] path = new int[right - left];
                for (int i = left; i < right; i++) {
                    path[i - left] = i;
                }
                ret.add(path);
                // 窗口向右滑动
                sum -= left;
                left++;
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
