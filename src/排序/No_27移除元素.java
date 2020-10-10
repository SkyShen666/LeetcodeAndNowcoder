package 排序;

public class No_27移除元素 {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int res = removeElement(nums, 3);
        System.out.println(res);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }
}
