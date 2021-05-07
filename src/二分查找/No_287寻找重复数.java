package 二分查找;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
 */
public class No_287寻找重复数 {
    public int findDuplicate(int[] nums) {
        // 数字在[1, n]之间，包括1和n，nums.length = n + 1。
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
