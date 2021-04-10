package 动态规划;

// 动态规划
// 参考题解：
// https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-3/
public class No_516最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        /**
         * 注意遍历顺序：i从倒数第2个字符(倒数第一个已经初始化了)开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
         * 相当于填表格的顺序：从最后一列开始，逐行填（从左至右）
         */
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
