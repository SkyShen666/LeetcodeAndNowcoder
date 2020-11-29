package 数组与矩阵;

import java.util.Arrays;

public class No_645Set_Mismatch_Easy {
    public static void main(String[] args) {
        int[] nums = {2, 2};
        nums = findErrorNums(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int[] findErrorNums(int[] nums) {
        // 整理
        // 例如把[2,3,4,5,6,3] 整理成 [3,2,3,4,5,6]
        // [1,2,2,4] 整理后还是 [1,2,2,4]
        // 把对的数字都放在自己该在的位置
        for (int i = 0; i < nums.length; i++) {
            // 本应该是：nums[i] = i + 1，若不在应该的位置等式就不成立
            // 1. 在这个位置上的数就不对
            // 2. 在它本应该在的位置上也不对
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
/*    private static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] errorNums = new int[2];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] - nums[i - 1] == 2) {
                errorNums[0] = nums[i] - 2;
                errorNums[1] = nums[i] - 1;
                break;
            } else if (nums[i] == nums[i - 1]) {
                errorNums[0] = nums[i] == 1 ? nums[i] : nums[i] - 1;
                errorNums[1] = nums[i] == 1 ? nums[i] + 1 : nums[i];
            }
        }
        return errorNums;
    }*/
}
