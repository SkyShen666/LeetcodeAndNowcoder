package 排序;

// https://blog.csdn.net/zdp072/article/details/44227317
// 用数组模拟即可，数组的末尾元素就是最大值
public class No_912排序数组 {
    public int[] sortArray(int[] nums) {
        // 将数组整理成堆
        heapify(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = nums.length - 1; i >= 1; i--) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // i - 1 逐步减少堆有序的部分
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            siftDown(nums, 0, i - 1);
        }

        return nums;
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private void heapify(int[] nums) {
        // 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, nums.length - 1);
        }
    }

    /**
     * @param nums
     * @param i    当前下沉元素的下标
     * @param end  [0, end] 是 nums 的有效部分
     */
    private void siftDown(int[] nums, int i, int end) {
        while (2 * i + 1 <= end) {
            int k = 2 * i + 1; // 左孩子下标
            if (k + 1 <= end && nums[k + 1] > nums[k]) {
                k++; // 下标移到右孩子
            }
            if (nums[k] > nums[i]) {
                swap(nums, k, i);
            } else {
                break;
            }
            i = k; // 向下迭代，保证当前整个堆符合大顶堆的要求
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
