package 动态规划;

/**
 * 注意此题与518零钱兑换的区别！
 * 此题排列可以无序
 * 可以看liweiwei题解
 * https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/
 */
public class No_377组合总和4 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return target == 0 ? 1 : 0;
        }

        int n = nums.length;
        // dp[i] 表示target = i 组合的个数
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    // 当i==nums[j]时，以nums[j]为结尾的所有排列就一个，所以可知直接使dp[0]=1实现这一目的
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }

        return dp[target];
    }
}

