package 数组与矩阵;
// 前缀和
public class No_303区域和检索_数组不可变 {
    private int[] sums;

    public No_303区域和检索_数组不可变(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int res = sums[j + 1] - sums[i];
        return res;
    }
}
