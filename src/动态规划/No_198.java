package 动态规划;

public class No_198 {
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
