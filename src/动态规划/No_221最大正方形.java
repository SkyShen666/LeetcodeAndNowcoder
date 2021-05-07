package 动态规划;

/**
 * 动态规划解决。
 * 参考题解：
 * https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 */
public class No_221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        // dp[i][j]：以矩阵matrix(i - 1, j - 1)为 右下角 的正方形的最大边长
        // 相当于已经预处理新增第一行、第一列均为0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }

        return max * max;
    }
}
