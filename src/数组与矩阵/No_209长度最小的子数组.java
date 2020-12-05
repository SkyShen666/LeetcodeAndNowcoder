package 数组与矩阵;

// 方法二：前缀和 + 二分查找
// 参考题解：
// https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
public class No_209长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int minLen = n + 1;
        int[] sums = new int[n + 1];
        // 记录前i个元素的前缀和
        // 如 sums[2] = nums[0] + nums[1]; 即前两个元素和
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        // 找长度最小的子组
        for (int i = 1; i <= n; i++) {
            int target = sums[i - 1] + s;
            int end = binarySearch(sums, target);
            if (end != -1 && end <= n) {
                minLen = Math.min(minLen, end - (i - 1));
            }
        }

        return minLen == n + 1 ? 0 : minLen;
    }

    private int binarySearch(int[] sums, int target) {
        int low = 0, high = sums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return sums[low] >= target ? low : -1;
    }
}

/**
 * 方法一： 暴力法
 * public int minSubArrayLen(int s, int[] nums) {
 * if (nums == null || nums.length == 0) {
 * return 0;
 * }
 * int min = nums.length + 1;
 * for (int i = 0; i < nums.length; i++) {
 * if (min == 1) {
 * break;
 * }
 * int temp = nums[i];
 * int j = i + 1;
 * while (j < nums.length && temp < s) {
 * temp += nums[j];
 * j++;
 * }
 * if (temp >= s) {
 * min = j - i < min ? j - i : min;
 * }
 * }
 * return min == nums.length + 1 ? 0 : min;
 * }
 */
