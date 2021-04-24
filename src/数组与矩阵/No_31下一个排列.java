package 数组与矩阵;

/**
 * LeetCode_31 下一个排列
 * 题干的意思是：找出这个数组排序出的所有数中，刚好比当前数大的那个数
 * 比如当前 nums = [1,2,3]。这个数是123，找出1，2，3这3个数字排序可能的所有数，排序后，比123大的那个数 也就是132
 * 如果当前 nums = [3,2,1]。这就是1，2，3所有排序中最大的那个数，那么就返回1，2，3排序后所有数中最小的那个，也就是1，2，3 -> [1,2,3]
 * 参考题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
 */
public class No_31下一个排列 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        // 从后向前遍历
        int i = nums.length - 2;
        // 找出第一个不满足升序要求的（以从后向前的角度）
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 找到并交换一个比nums[i]更大的数（同样需要最大索引，需要从后往前遍历）
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            if (i != j) { // 只有i=0，j=0时相等
                swap(nums, i, j);
            }
        }
        // [i+1:] 都是升序，需要改成降序，翻转即可
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
