package 贪心思想;

import java.util.Arrays;
import java.util.Comparator;

public class No_435无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //Arrays.sort(intervals, Comparator.comparing(o -> o[1]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = 1;

        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return intervals.length - count;
    }
}
