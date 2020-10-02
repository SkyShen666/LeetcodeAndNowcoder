package 二分查找;

public class No_34第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = findFirstPosition(nums, target);
        if (res[0] == -1) {
            return res;
        }
        res[1] = findLastPosition(nums, target);
        return res;
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 下一轮搜索空间为[left, right]
                right = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            // 注意 right - left + 1，将mid划分到右边，避免出现死循环
            // 若采用(right - left),将mid划分到左边，在剩余两个数时
            // left = mid 这里将会出现死循环，left不会增加,跳不出left < right
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                // 下一轮搜索区间为[mid, right]
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] res = searchRange(nums, 8);
        System.out.println(res[0] + " " + res[1]);
    }
}
