package 动态规划;

/**
 * 动态规划
 * 状态转移过程中涉及到两类状态，且这两类状态不相互独立，互相都可进行转移。
 * 参考题解：
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/qing-xi-yi-dong-de-dong-tai-gui-hua-jie-fa-shi-yon/
 */
public class No_978最长湍流子数组 {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        // 对应此时是上升的还是下降的
        // f[i] 为 [0 ~ i - 1] 中 最后一段为“上升”的数组
        int[] dpUp = new int[n + 1];
        // g[i] 为 [0 ~ i - 1] 中 最后一段为“下降”的数组
        int[] dpDown = new int[n + 1];
        dpUp[1] = 1;
        dpDown[1] = 1;
        int max = 1;

        for (int i = 2; i <= n; i++) {
            // 最后一段上升
            dpUp[i] = A[i - 2] < A[i - 1] ? dpDown[i - 1] + 1 : 1;
            // 最后一段下降
            dpDown[i] = A[i - 2] > A[i - 1] ? dpUp[i - 1] + 1 : 1;

            // 更新最大值
            max = Math.max(max, dpUp[i]);
            max = Math.max(max, dpDown[i]);
        }

        return max;
    }
}
