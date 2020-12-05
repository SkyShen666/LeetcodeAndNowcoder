package 贪心思想;

import java.util.Arrays;
import java.util.Comparator;
// 此题的箭是垂直向上发射的

// 最近新增了Test Case， [[-2147483646,-2147483645],[2147483646,2147483647]] 就过不了了，
// 这是因为差值过大而产生溢出。
// sort的时候不要用a-b来比较，要用Integer.compare(a, b)!!!
public class No_452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int n = points.length;
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int end = points[0][1];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            int begin = points[i][0];
            if (begin > end) {
                cnt++;
                end = points[i][1];
            }
        }

        return cnt;
    }
}

//  Arrays.sort(points,new Comparator<int[]>(){
//      @Override
//      public int compare(int[]o1,int[]o2){
//          return o1[1]-o2[1];
//      }
//  });