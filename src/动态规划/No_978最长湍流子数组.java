package 动态规划;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/qing-xi-yi-dong-de-dong-tai-gui-hua-jie-fa-shi-yon/
 */
public class No_978最长湍流子数组 {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        // f[i] 为 [0 ~ i - 1] 中 最后一段为“上升”的数组
        int[] up = new int[n + 1];
        // g[i] 为 [0 ~ i - 1] 中 最后一段为“下降”的数组
        int[] down = new int[n + 1];

        up[1] = 1;
        down[1] = 1;

        int max = 1;
        for (int i = 2; i <= n; i++) {
            // 最后一段上升
            up[i] = A[i - 2] < A[i - 1] ? down[i - 1] + 1 : 1;

            // 最后一段下降
            down[i] = A[i - 2] > A[i - 1] ? up[i - 1] + 1 : 1;

            // 更新最大值
            max = Math.max(max, up[i]);
            max = Math.max(max, down[i]);
        }

        return max;
    }
}
