package 贪心思想;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class No_406根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        //Arrays.sort(people, (a,b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        //身高从大到小，k从小到大排序，再按这个顺序逐个插入到队列中，因为身高矮的相对于升高高的是“看不见的”
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> queue = new LinkedList<>();
        for (int[] p : people) {
            queue.add(p[1],p);
        }

        return queue.toArray(new int[people.length][2]);
    }
}
