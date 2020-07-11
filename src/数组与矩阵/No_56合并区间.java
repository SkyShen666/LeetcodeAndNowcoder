package 数组与矩阵;

import java.util.*;

/**
 * 先排序，再两两合并
 * 参考 Sweetiee 答案
 *
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
        // 根据每个区间的起始排序（升序）
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        // 此时代表res为空
        int idx = -1;
        for (int[] interval : intervals) {
            // 若res为空，或res上一个区间的末尾，小于下一个区间的开始
            // 则直接加入res
            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        // 注意返回res中有数据长度的数组
        // 并且idx代表的索引，这里copyOf()方法的newLength是新数组长度，idx要+1
        return Arrays.copyOf(res, idx + 1);
    }
}
