package 数组与矩阵;

/**
 * 题目描述：
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 思路方法：
 *      若target = 0 在左半段， 则数组成为 [x,x,x,x,0,1,2],x为最小整数
 *   此时数组又变成了有序数组，二分查找即可。
 *      若target在右半段 。。。。。。
 */
public class No_33搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            // 若target在左半段,需要考虑只有一个数的情况 需要“=”
            if (target >= nums[0]) {
                // 并且mid在右半段
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {  // target在右半段
                // 并且mid在左半段，nums[mid] 可能与nums[0] 处于同一位置，一定别忘了“=”
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
