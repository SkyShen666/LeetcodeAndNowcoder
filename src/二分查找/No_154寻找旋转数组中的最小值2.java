package 二分查找;

public class No_154寻找旋转数组中的最小值2 {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 警惕{1,3,3} 没旋转
            // {3,3,1,3}
            // 防止没有旋转和最右侧元素与左侧元素重复
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int res = findMin(nums);
        System.out.println(res);
    }
}
