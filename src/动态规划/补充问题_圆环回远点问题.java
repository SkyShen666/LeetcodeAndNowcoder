package 动态规划;

import java.util.Scanner;

/**
 * 题目描述：
 * 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 * 输入: 2
 * 输出: 2
 * 解释：有2种方案。分别是0->1->0和0->9->0
 *
 * 分析：
 * 本题考察的是动态规划。
 * 如果你之前做过leetcode的70题爬楼梯，则应该比较容易理解：走n步到0的方案数=走n-1步到1的方案数+走n-1步到9的方案数。
 * 因此，若设dp[i][j]为从0点出发走i步到j点的方案数，则递推式为：
 * dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length]
 * ps:公式之所以取余是因为j-1或j+1可能会超过圆环0~9的范围
 */
public class 补充问题_圆环回远点问题 {
    private int backToOrigin(int n) {
        int length = 10;
        // dp[i][j] 表示从0点出发走 i步到 j点的方案数
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
            }
        }

        return dp[n][0];
    }

    public static void main(String[] args) {
        补充问题_圆环回远点问题 obj = new 补充问题_圆环回远点问题();
//        Scanner sc = new Scanner();

    }
}
