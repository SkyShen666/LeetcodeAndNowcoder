package 动态规划;
import java.util.*;
public class No_300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];  // dp[i] 表示以 nums[i] 结尾的[上升子序列]的长度
        Arrays.fill(dp, 1); // 对于每个 dp[i] 都满足最小值为 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
