package 动态规划;

import java.util.Arrays;

// 参考题解：
//https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/
public class No_鸡蛋掉落 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];

        // 初始化整个数组
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 初始化第0行
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }

        // 初始化第1行
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }

        // 初始化第0列和第1列
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left = 1;
                int right = i;
                // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                while (left < right) {
                    // 一定注意：mid要向上取整，否则会超时，因为楼层从1开始，若从0开始才使用(right - left) / 2
                    int mid = left + (right - left + 1) / 2;
                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1);
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        No_鸡蛋掉落 egg = new No_鸡蛋掉落();
        int res = egg.superEggDrop(3, 14);
        System.out.println(res);
    }
}
