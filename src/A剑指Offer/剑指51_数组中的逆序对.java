package A剑指Offer;

/**
 * 考察点：归并排序
 * 就是问你归并排序过程中，你有几次是先取出右边的数来合并的。
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
 */
public class 剑指51_数组中的逆序对 {
    private int[] nums;
    private int[] tmp; // 存储合并前的左右子数组

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int l, int r) {
        // 递归终止条件
        if (l >= r) {
            return 0;
        }

        // 1. 递归划分阶段
        int mid = (l + r) / 2;
        int ret = mergeSort(l, mid) + mergeSort(mid + 1, r);

        // 2. 合并阶段（并统计逆序对数量）
        // 2.1 tmp 存储合并前的左右子数组
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        int i = l, j = mid + 1;
        // 2.2 合并
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) { // tmp 的左子数组已合并完，添加右子数组当前元素tmp[j]
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) { // tmp 的右子数组已合并完 || 左子数组当前元素 <= 右子...（注意要 “ <= ”, 等于的情况不构成逆序对）
                nums[k] = tmp[i++];
            } else {  // (tmp[i] > tmp[j]), 此时构成 mid - i + 1 个逆序对
                nums[k] = tmp[j++]; // 把较小的tmp[j] 安排到左边
                ret += mid - i + 1; // 统计逆序对,右边的数组和左边的数组都是从小到大的，此时左半段中的比右半段中的这个元素(tmp[j])大的元素个数为：mid - i + 1
            }
        }

        return ret;
    }
}
