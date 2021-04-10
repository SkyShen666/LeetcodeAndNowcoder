package 动态规划;

/**
 * 这道题就是找一个子集是正数，剩下是负数，他们之和等于S
 *
 * 假设正数集和为P，负数集合为N，
 *          sum(P) + sum(N) = sum
 *          sum(P) - sum(N) = S
 *          ==>
 *          2sum(P) = sum + s
 *          ==>
 *          sum(P) = (sum + s) / 2
 * 所以题目就转化成找一个正数集合之和sum(P)为(S + sum(nums)) / 2，
 * 当然这里的(S + sum(nums))大于0
 * 并且可以被2整除。
 * ==> 即搞成了0-1背包问题
 * 作者：powcai
 * 链接：https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-by-powcai-22/
 */
public class No_494目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        if (n == 0) {
            return S == 0 ? 1 : 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((S + sum) % 2 == 1) {
            return 0;
        }
        if (sum < S) {
            return 0;
        }

        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}
