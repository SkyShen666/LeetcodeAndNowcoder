package 数组与矩阵;

import java.util.Arrays;

public class No_645Set_Mismatch_Easy {
    public static void main(String[] args) {
        int[] nums = {2,2};
        nums = findErrorNums(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
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
