package A剑指Offer;

// 动态规划
// 参考题解：
// https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
public class 剑指46_把数字翻译成字符串 {
    public int translateNum(int num) {
        // 字符串遍历
        String str = String.valueOf(num);
        int n = str.length();
        // dp[i] 表示 前i位数字的翻译方法数量
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 无数字，翻译方法数量 = 1
        dp[1] = 1;  // 第1位数字，翻译方法数量 = 1
        for (int i = 2; i <= n; i++) {
            String tmp = str.substring(i - 2, i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                // 01、02、26、27这种:只能被翻译成如(01: 0-a, 1-b)、(27: 2-c, 7-h),只有一种翻译方法，所以dp[i]和dp[i-1]相等
                dp[i] = dp[i - 1];
            }
        }

        return dp[n];
    }
}
