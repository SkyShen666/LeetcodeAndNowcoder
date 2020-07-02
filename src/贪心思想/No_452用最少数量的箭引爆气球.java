package 贪心思想;

import java.util.Arrays;
import java.util.Comparator;

public class No_452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int x_end = points[0][1];
        for (int[] point : points) {
            int start = point[0];
            if (start > x_end) {
                count++;
                x_end = point[1];
            }
        }
        return count;
    }
}
