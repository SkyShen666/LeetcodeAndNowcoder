package 动态规划;

import java.util.Arrays;

// 参考题解：
// https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
public class No_887鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        /**
         * dp[i][j]: 一共有 i 层楼梯（注意：这里 i 不表示高度）的情况下，使用 j 个鸡蛋的最少实验的次数。
         * i 表示的是楼层的大小，不是高度（第几层）的意思，例如楼层区间 [8, 9, 10] 的大小为 3。
         * j 表示可以使用的鸡蛋的个数，它是约束条件。
         *
         * 第一个维度最先容易想到的是表示楼层的高度，这个定义的调整是在状态转移的过程中完成的。
         * 因为如果通过实验知道了鸡蛋的 F 值在高度区间 [8, 9, 10] 里，这个时候只有 1 枚鸡蛋，显然需要做 3 次实验，和区间的大小是相关的。
        */
        int[][] dp = new int[N + 1][K + 1];
        // 初始化整个数组
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // 初始化第0行: 楼层为 0 的时候，不管鸡蛋个数多少，都测试不出鸡蛋的 F 值，故全为 0；
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }
        // 初始化第1行: 楼层为 1 的时候，0 个鸡蛋的时候，扔 0 次，1 个以及 1 个鸡蛋以上只需要扔 1 次；
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }
        // 初始化第0列和第1列
        // 鸡蛋个数为 0 的时候，不管楼层为多少，也测试不出鸡蛋的 F 值，故全为 0，虽然不符合题意，但是这个值有效，它在后面的计算中会被用到；
        // 鸡蛋个数为 1 的时候，这是一种极端情况，要试出 F 值，最少次数就等于楼层高度；
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int low = 1;
                int high = i;
                // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                while (low < high) {
                    // 一定注意：mid要向上取整，否则会超时，因为楼层从1开始，若从0开始才使用(high - low) / 2
                    int mid = low + (high - low + 1) / 2;
                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        high = mid - 1;
                    } else {
                        low = mid;
                    }
                }
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[low - 1][j - 1], dp[i - low][j]) + 1);
            }
        }

        return dp[N][K];
    }

    public static void main(String[] args) {
        No_887鸡蛋掉落 egg = new No_887鸡蛋掉落();
        int res = egg.superEggDrop(3, 14);
        System.out.println(res);
    }
}
