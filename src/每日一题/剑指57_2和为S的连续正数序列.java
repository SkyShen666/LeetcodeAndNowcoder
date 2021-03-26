package 每日一题;

import java.util.*;

/**
 *  滑动窗口
 *  参考题解：
 *  https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 */
public class 剑指57_2和为S的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        int sum = 0;    // 滑动窗口元素总和
        int begin = 1, end = 1; // 滑动窗口起点和终点
        List<int[]> list = new LinkedList<>();
        while (begin <= target / 2) {
            if (sum < target) {
                sum += end;
                end++;
            } else if (sum > target) {
                sum -= begin;
                begin++;
            } else {
                int[] path = new int[end - begin];
                for (int i = begin; i < end; i++) {
                    path[i - begin] = i;
                }
                list.add(path);
                sum -= begin;
                begin++;
            }
        }

        return list.toArray(new int[0][0]);
    }
}
