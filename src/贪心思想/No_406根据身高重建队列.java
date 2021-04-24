package 贪心思想;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/406-gen-ju-shen-gao-zhong-jian-dui-lie-java-xian-p/
 */
public class No_406根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        //身高从大到小，k从小到大排序
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        // 再一个一个插入。（因为身高矮的相对于身高高的是“看不见的”）
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            // 指定插入的位置：p[1]，若插入的索引有元素，则将s[p1[1], n - 1]的所有元素向后移一格
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        No_406根据身高重建队列 test = new No_406根据身高重建队列();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
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