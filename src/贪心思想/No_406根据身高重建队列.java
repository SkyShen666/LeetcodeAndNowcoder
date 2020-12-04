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

        //身高从大到小，k从小到大排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        // 再按这个顺序逐个插入到队列中，因为身高矮的相对于身高高的是“看不见的”
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            // 指定插入的位置：p[1]
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        No_406根据身高重建队列 test = new No_406根据身高重建队列();
        int[][] people = {{7,0}, {4,4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = test.reconstructQueue(people);
        for (int[] p : people) {
            System.out.print("[");
            for (int n : p) {
                System.out.print(n + ",");
            }
            System.out.print("] ");
        }
    }
}

//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
//            }
//        });