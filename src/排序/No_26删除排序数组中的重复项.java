package 排序;

public class No_26删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
