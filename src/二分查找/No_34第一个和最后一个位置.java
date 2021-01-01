package 二分查找;

public class No_34第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] ret = new int[]{-1, -1};
        ret[0] = findFirstPosition(nums, target);
        if (ret[0] == -1) {
            return ret;
        }
        ret[1] = findLastPosition(nums, target);

        return ret;
    }

    private int findFirstPosition(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            // 当区间长度为偶数时：此种划分方式mid落在左边，区间将不断向左缩小。
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                // 下一轮搜索空间为[low, high]
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nums[low] == target ? low : -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            // 当区间长度为偶数时：此种划分方式mid落在右边，区间将不断向右缩小。
            // 注意 right - left + 1，将mid划分到右边，避免出现死循环
            // 若采用(right - left),将mid划分到左边，在剩余两个数时
            // left = mid 这里将会出现死循环，left不会增加,跳不出left < right
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] == target) {
                // 下一轮搜索区间为[mid, right]
                low = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
