package 数组与矩阵;

public class No_189旋转数组 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k = k - nums.length;
        }
        while(k-- > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }
}
