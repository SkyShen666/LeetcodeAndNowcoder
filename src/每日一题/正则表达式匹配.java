package 每日一题;


/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class 正则表达式匹配 {
    public boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        //初始化“”空串和pattern的匹配关系。
        //a*a*a*a*这种能够匹配空串，其余的都是false
        //奇数位不管什么都是false，偶数位皆为*时则：dp[0][i] = dp[0][i-2]
        for (int i = 2; i <= n; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = str[i - 1];
                char pc = pattern[j - 1];
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    if (dp[i][j - 2]) { //匹配0个
                        dp[i][j] = true;
                    } else if (sc == pattern[j - 2] || pattern[j - 2] == '.') { //匹配多个字符
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        String s = "sdasds";
        char[] array = s.toCharArray();
        return dp[m][n];
    }
}
