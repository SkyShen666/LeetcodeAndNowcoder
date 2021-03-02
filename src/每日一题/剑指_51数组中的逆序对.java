package 每日一题;

//考察点：归并排序
// 就是问你归并排序过程中，你有几次是先取出右边的数来合并的。
public class 剑指_51数组中的逆序对 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int n = nums.length;
        int[] tmp = new int[n];

        return reversePairs(nums, 0, n - 1, tmp);
    }

    // 计算逆序对个数并排序
    private int reversePairs(int[] nums, int low, int high, int[] tmp) {
        if (low == high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int leftPairs = reversePairs(nums, low, mid, tmp);
        int rightPairs = reversePairs(nums, mid + 1, high, tmp);

        // 若整个数组已经有序，就无需合并。
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, low, mid, high, tmp);

        return leftPairs + rightPairs + crossPairs;
    }

    // nums[low..mid] 有序，nums[mid + 1..high] 有序
    private int mergeAndCount(int[] nums, int low, int mid, int high, int[] tmp) {
        for (int i = low; i <= high; i++) {
            tmp[i] = nums[i];
        }

        int i = low;
        int j = mid + 1;
        int cnt = 0;

        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j];
                j++;
            } else if (j == high + 1) {
                nums[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                i++;
            } else {
                nums[k] = tmp[j];
                j++;

                cnt += (mid - i + 1);
            }
        }

        return cnt;
    }
}
