package 动态规划;

/**
 * 参考题解：看的视频题解，注意是如何填写表格的
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 * 例如：A ABCCBA A
 * 看字符串的两头是否相等
 *      1）相等，则继续看中间子串是否为回文串：ABCCBA
 *      2）若不相等，则不是回文串，继续查看中间的子字符串，i++, j--。
 * dp[i][j]: s[i,j]是否为回文串
 * 状态转移方程：dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
 * 若 s[i] == s[j]
 *      须注意边界条件： (j - 1) - (i + 1) + 1 < 2 ==> j - i < 3  <==> j - i + 1 < 4，
 *                      即s[i,j]长度为2或3时，不用进一步检查s[i,j]的子串是否为回文串（中间无元素，或中间只有一个元素）
 */
public class No_5最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 1;
        int begin = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + max);
    }
}
