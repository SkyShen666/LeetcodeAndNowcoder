package 动态规划;
import java.util.*;

// 把环形数组拆分成两个线性数组: [0, n - 2], [1, n -1]
// 偷了第一家，就不能偷最后一家；偷了最后一家，就不能偷第一家。
// 这样就变成了 198题，打家劫舍1
// 参考题解：
// https://leetcode-cn.com/problems/house-robber-ii/solution/fen-cheng-liang-ge-wen-ti-by-powcai/
public class No_213打家劫舍2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n  = nums.length;
        if (n == 1) {
            return nums[0];
        }

        return Math.max(robRange(Arrays.copyOfRange(nums, 0, n - 1)), robRange(Arrays.copyOfRange(nums, 1, n)));
    }

    private int robRange(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[n];
    }
}
