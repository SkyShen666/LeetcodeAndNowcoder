package 贪心思想;

public class No_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = maxSubArray(nums);
        System.out.println(sum);
    }

    private static int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int tempMax = nums[0];
        int maxSum = tempMax;
        for (int i = 1; i < nums.length; i++){
            tempMax = tempMax > 0 ? tempMax + nums[i] : nums[i];
            maxSum = Math.max(maxSum,tempMax);
        }
        return maxSum;
    }
}
