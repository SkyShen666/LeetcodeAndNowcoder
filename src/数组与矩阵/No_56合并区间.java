 package 数组与矩阵;

import java.util.*;

/**
 * 先排序，再两两合并
 * 参考 Sweetiee 答案
 * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 * Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
 * 假设传来两个值，v1 与 v2，那么他们的先后顺序以 v1[0] 比 v2[0] 的结果为准，
 * 即：若 v1[0] < v2[0] 则 v1 < v2，若 = 则 =，若 > 则 >
 *
 * 举一反三：Arrays.sort(intervals, (v1, v2) -> v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0]);
 * 表示：传来两个值 v1 与 v2，若 [0] 相同，则按 [1] 降序；若不同则按 [0] 升序。
 * 趁热打铁题目 354. 俄罗斯套娃的信封问题
 */
public class No_56合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]); // 根据每个区间的起始排序（升序）
        int[][] ret = new int[intervals.length][2];
        int i = -1; // 此时代表res为空
        for (int[] interval : intervals) {
            if (i == -1 || ret[i][1] < interval[0]) { // 上一个返回的区间的右边界小于当前遍历到的区间的左边界
                i++;
                ret[i] = interval;
            } else { // 查看是否需要更新上一返回区间的右边界
                ret[i][1] = Math.max(ret[i][1], interval[1]);
            }
        }

        // 注意返回ret中有数据长度的数组,ret在定义时定义的 长度为 intervals.length, 实际上可能不需要这么多。
        // 并且i代表的索引，这里copyOf()方法的newLength是新数组长度，i要+1
        return Arrays.copyOf(ret, i + 1);
    }
}
