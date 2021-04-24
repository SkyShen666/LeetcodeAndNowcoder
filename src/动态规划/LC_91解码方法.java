package 动态规划;

public class LC_91解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        // 若第一个数字为0,直接返回0
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 若当前元素是0，则需要进行判断：
            //  1. 若前一个元素是0：即与当前元素组成00
            //  2. 若前一个元素 > 2：例如与当前元素组成30
            // 都直接返回 0.
            if (s.charAt(i - 1) == '0' && (s.charAt(i - 2) == '0' || s.charAt(i - 2) > '2')) {
                return 0;
            }
            // 已把不符合条件的情况过滤掉
            String tmp = s.substring(i - 2, i);
            if (s.charAt(i - 1) == '0') { // 只能与前面元素组合
                dp[i] = dp[i - 2];
            } else if (tmp.compareTo("11") >= 0 && tmp.compareTo("26") <= 0) { // 20的情况已经在前面已经过滤掉了
                dp[i] = dp[i - 2] + dp[i - 1]; // 例如：11可拆分成(1,1)和(11)两种情况，两种组合相加
            } else {  // 这里只处理(10, 20)
                dp[i] = dp[i - 1];
            }
        }

        return dp[n];
    }
}
