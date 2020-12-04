package 贪心思想;

import java.util.Arrays;
import java.util.Comparator;

public class No_435无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        // 记录重叠区间个数
        int cnt = 1;
        // 排序后的第一个区间必然不重叠
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int begin = intervals[i][0];
            if (begin >= end) {
                cnt++;
                end = intervals[i][1];
            }
        }

        // 注意返回结果是：需要移除的重叠区间个个数
        return n - cnt;
    }
}

//    Arrays.sort(intervals, new Comparator<int[]>() {
//        @Override
//        public int compare(int[] a, int[] b) {
//            return a[1] - b[1];
//        }
//    });


//    Arrays.sort(intervals, Comparator.comparing(o -> o[1]));

