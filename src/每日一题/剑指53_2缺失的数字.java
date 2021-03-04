package 每日一题;

// 二分查找
// 参考题解：
// https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
public class 剑指53_2缺失的数字 {
    public int missingNumber(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
