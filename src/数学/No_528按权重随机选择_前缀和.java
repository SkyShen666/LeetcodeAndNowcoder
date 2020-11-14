package 数学;

import java.util.Random;

public class No_528按权重随机选择_前缀和 {
    private int sum;
    private int[] sums;

    public No_528按权重随机选择_前缀和(int[] w) {
        if (w.length > 0) {
            int n = w.length;
            sum = 0;
            sums = new int[n];
            for (int i = 0; i < n; i++) {
                sum += w[i];
                sums[i] = sum;
            }
        }
    }

    public int pickIndex() {
        int num = new Random().nextInt(sum);
        for (int i = 0; i < sums.length; i++) {
            if (num < sums[i]) {
                return i;
            }
        }
        return 0;
    }
}
