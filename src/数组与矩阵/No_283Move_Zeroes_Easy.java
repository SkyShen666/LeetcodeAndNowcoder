package 数组与矩阵;

public class No_283Move_Zeroes_Easy {
    public static void main(String[] args) {
        int[] nums = {1,0};
        nums = moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }



/*
    private static int[] moveZeroes(int[] nums) {
        int i = 0;
        int j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(nums,i,j);
                i++;
                j++;
            } else if (nums[i] == 0 && nums[j] == 0) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return nums;
    }

    private static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
*/
}
