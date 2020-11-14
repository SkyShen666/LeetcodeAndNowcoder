package 数学;

import java.util.*;

public class 蓄水池抽样算法 {
    public static int[] randomReservoir(int[] datastream, int m) {
        int[] reservoir = new int[m];

        for (int i = 0; i < m; i++) {
            reservoir[i] = datastream[i];
        }

        int n = datastream.length;
        for (int i = m; i < n; i++) {
            int num = new Random().nextInt(i + 1);
            if (num < m) {
                reservoir[num] = datastream[i];
            }
        }
        return reservoir;
    }

    public static void main(String[] args) {
        int[] datastream = new int[]{1,2,3,4,5,6,7,8,9,10};
        int m = 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            int[] res = randomReservoir(datastream, m);
            for (int j = 0; j < m; j++) {
                map.put(res[j], map.getOrDefault(res[j], 1) + 1);
            }
        }
        System.out.println(map);
    }
}
