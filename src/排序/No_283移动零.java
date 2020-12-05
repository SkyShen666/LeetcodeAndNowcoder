package 排序;

public class No_283移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = i; j < n; j++) {
            nums[j] = 0;
        }
    }
}
