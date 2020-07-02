package 每日一题;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class 数字在排序数组中出现的次数 {

    public static int GetNumberOfK(int[] array, int k) {
        int first = binarySearch(array, k);
        int last = binarySearch(array, k + 1);
        if (first == array.length || array[first] != k) //越界或 != k
            return 0;
        else
            return last - first;
    }

    private static int binarySearch(int[] nums, int k) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= k)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
