package 每日一题;


// *：0个或多个前一个元素，多个：1个或2个以上
// .: 匹配任意单个字
// 隐含条件：
//      1. * 不会出现在字符串的开头
//      2. * 前面不能是 *，比如 “a * * b” 就不行

// leetcode上的特殊的case：
// ("aaa", "ab*a*c*a") : true
// 说明了*可以匹配单个字符即：a* 可以为 a

// 参考题解：
// https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/
public class 正则表达式匹配 {
    // #代表任意字符
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length(), n = p.length();
        // dp[i][j]矩阵：行标i对应s的i- 1，列表j对应p的j - 1
        // dp[i][j] 表示s的前i个是否能被p的前j个匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // s和p都是空串时=true
        dp[0][0] = true;

        // 首行初始化
        // #*#*#*这种能够匹配空串，其余的都是false
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') { // 匹配
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') { // 需要看*前一个元素
                    if (sc != p.charAt(j - 2) && p.charAt(j - 2) != '.') { // 匹配0个：前一个元素不匹配 且不为任意元素
                        dp[i][j] = dp[i][j - 2];
                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') { // 匹配多个字符(包含单个)
                        dp[i][j] = (dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2]);
                        /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                        */
                    }
                }
            }
        }

        return dp[m][n];
    }
}

// 简化版本：
//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) return false;
//
//        int m = s.length(), n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        dp[0][0] = true;
//
//        //"" 和p的匹配关系初始化，a*a*a*a*a*这种能够匹配空串，其他的是都是false。
//        //  奇数位不管什么字符都是false，偶数位为* 时则: dp[0][i] = dp[0][i - 2]
//        for (int i = 2; i <= n; i+= 2) {
//            if (p.charAt(i - 1) == '*') {
//                dp[0][i] = dp[0][i - 2];
//            }
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                char sc = s.charAt(i - 1);
//                char pc = p.charAt(j - 1);
//                if (sc == pc || pc == '.') {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else if (pc == '*') {
//                    if (dp[i][j - 2]) {
//                        dp[i][j] = true;
//                    } else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                }
//            }
//        }
//
//        return dp[m][n];
//    }