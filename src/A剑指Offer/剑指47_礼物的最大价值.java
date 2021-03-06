package A剑指Offer;

// 动态规划
// 参考题解:
// https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
public class 剑指47_礼物的最大价值 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] 表示从 grid[0][0] 到 grid[i - 1][j - 1] 的最大值
        // 默认初始化dp 的 第一行和第一列都为 0
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 本次到达位置 + 上一次到达位置的最大路程
                dp[i][j] = grid[i - 1][j - 1] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
