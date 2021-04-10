package 动态规划;

/**
 * 经典的Longest Common Substring算法
 */
public class No_1143最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j] 表示 text1前i个字符 与 text2前j个字符 的最长公共子序列的 长度
        int[][] dp = new int[m + 1][n + 1];
        /**
         * 按行填表格，每行从左到右，保证子问题都已经计算并保存完毕。
         * 这样从每个字符串的头部开始遍历，即i从0，j从0开始，在对行子问题进行利用时如dp[i - 1][j - 1] 会出现数组越界问题
         * 故增加一个缓冲行和列。即 new int[m + 1][n + 1], 第一行和第一列均为0。
         */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 对上一次匹配的结果 + 1（即t1[0, i - 2], t2[0, j - 2], 这次比较的是t1[0, i - 1], t2[0, j - 1]）
                } else {
                    // 这次匹配补上，取上次保存过的子问题的最大值(即取t1[0, i - 1], t2[0, j - 2]比较的值，或t1[0, i - 2], t2[0, j - 1]的值，这俩值均已计算过)
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
