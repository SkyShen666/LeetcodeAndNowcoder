package 每日一题;

import java.util.*;

/**
 *  滑动窗口
 *  参考题解：
 *  https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 */
public class 剑指57_2和为S的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int low = 1, high = 1;
        int sum = 0;
        List<int[]> list = new LinkedList<>();

        while (low <= target / 2) {
            if (sum < target) {
                sum += high;
                high++;
            } else if (sum > target) {
                sum -= low;
                low++;
            } else {
                int[] path = new int[high - low];
                for (int i = low; i < high; i++) {
                    path[i - low] = i;
                }
                list.add(path);
                // 窗口滑动
                sum -= low;
                low++;
            }
        }

        return list.toArray(new int[0][0]);
    }
}
