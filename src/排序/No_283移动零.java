package 排序;

public class No_283移动零 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return;
        }
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = i; j < len; j++) {
            nums[j] = 0;
        }
    }
}
