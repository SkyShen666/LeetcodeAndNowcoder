package 动态规划;

public class No_198打家劫舍1 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int totalMoney = rob(nums);
        System.out.println("totalMoney:" + totalMoney);
    }

    /**
     * 动态规划，dp[i] = max(dp[i-2]+nums[i],dp[i-1])
     * @param nums
     * @return
     */
    private static int rob(int[] nums) {
        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < nums.length; i++){
            int curr = Math.max(pre1 + nums[i],pre2);
            pre1 = pre2;
            pre2 = curr;
        }
        return pre2;
    }
}
// 优化前
//
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int n = nums.length;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
//        }
//
//        return dp[n];
//    }
//