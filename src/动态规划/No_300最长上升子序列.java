package 动态规划;
import java.util.*;
public class No_300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int res = 0;

        // dp[i] 表示 以 nums[i] 结尾 的「上升子序列」的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
