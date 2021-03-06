package 数组与矩阵;

// 三次反转法：（官方题解）
public class No_189旋转数组 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == k) {
            return;
        }
        int n = nums.length;
        // 注意：坑点！
        if (n < k) {
            k = k - n;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
/**
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
 */