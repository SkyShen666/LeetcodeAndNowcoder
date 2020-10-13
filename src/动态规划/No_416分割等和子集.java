package 动态规划;

public class No_416分割等和子集 {
    // 优化，状态压缩
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总和为奇数，不可能能划分成两个子集
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        // 所有只考虑从前i个数中选，是否有一个选法使总和等于j的集合。
        boolean[] dp = new boolean[sum + 1];

        //base case
        dp[0] = true;

        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[sum];
    }

    // 优化空间前
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总和为奇数，不可能能划分成两个子集
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        // 所有只考虑从前i个数中选，是否有一个选法使总和等于j的集合。
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case
        // j = 0，一个都不选
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                // dp[i - 1][j] 存储的是上一层循环的值，若优化成一维
                // dp[j] = dp[j] 右边的dp[j]还没有被更新过，存储的是上一层循环的值
                // 即 dp[j] = dp[j] 与 dp[i][j] = dp[i - 1][j] 是等价的。
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i])
                    dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i]];
                    // 优化：dp[j] = dp[j] | dp[j - num];
                    // 此时dp[j - num] 等价于 dp[i][j - num]，
                    // 由于是从小到大遍历j，所以j - num < j , 那么 j - num 会被先计算出来
                    // 所以此处的dp[j - num] 一定是第i层的, 即等价于dp[i][j - num]，与原方程不等价
                    // 而此处应该是dp[i - 1][j - num]，
                    // 所以把内层循环改成从大到小循环，就能保证在算dp[j]时，是先算dp[j] 再算dp[j - num]
                    // 那么此时的dp[j - num] 即为 上一层的 dp[j - num], 即等价于dp[i - 1][j - num]
            }
        }

        return dp[n - 1][sum];
    }
}



