package 二分查找;

public class No_540有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            first = first ^ nums[i];
        }
        return first;
    }
/*    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) /2;
            if (mid % 2 != 0) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l =  mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }*/
}
