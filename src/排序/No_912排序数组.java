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
     * 将数组整理成堆（大顶堆）
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
            if (nums[k] > nums[i]) { // 整理成大顶堆
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


//public class Solution {
//    // 归并排序
//
//    /**
//     * 列表大小等于或小于该大小，将优先于 mergeSort 使用插入排序
//     */
//    private static final int INSERTION_SORT_THRESHOLD = 7;
//
//    public int[] sortArray(int[] nums) {
//        int len = nums.length;
//        int[] temp = new int[len];
//        mergeSort(nums, 0, len - 1, temp);
//        return nums;
//    }
//
//    /**
//     * 对数组 nums 的子区间 [left, right] 进行归并排序
//     *
//     * @param nums
//     * @param left
//     * @param right
//     * @param temp  用于合并两个有序数组的辅助数组，全局使用一份，避免多次创建和销毁
//     */
//    private void mergeSort(int[] nums, int left, int right, int[] temp) {
//        // 小区间使用插入排序
//        if (right - left <= INSERTION_SORT_THRESHOLD) {
//            insertionSort(nums, left, right);
//            return;
//        }
//
//        int mid = left + (right - left) / 2;
//        // Java 里有更优的写法，在 left 和 right 都是大整数时，即使溢出，结论依然正确
//        // int mid = (left + right) >>> 1;
//
//        mergeSort(nums, left, mid, temp);
//        mergeSort(nums, mid + 1, right, temp);
//        // 如果数组的这个子区间本身有序，无需合并
//        if (nums[mid] <= nums[mid + 1]) {
//            return;
//        }
//        mergeOfTwoSortedArray(nums, left, mid, right, temp);
//    }
//
//    /**
//     * 对数组 arr 的子区间 [left, right] 使用插入排序
//     *
//     * @param arr   给定数组
//     * @param left  左边界，能取到
//     * @param right 右边界，能取到
//     */
//    private void insertionSort(int[] arr, int left, int right) {
//        for (int i = left + 1; i <= right; i++) {
//            int temp = arr[i];
//            int j = i;
//            while (j > left && arr[j - 1] > temp) {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }
//
//    /**
//     * 合并两个有序数组：先把值复制到临时数组，再合并回去
//     *
//     * @param nums
//     * @param left
//     * @param mid   [left, mid] 有序，[mid + 1, right] 有序
//     * @param right
//     * @param temp  全局使用的临时数组
//     */
//    private void mergeOfTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
//        System.arraycopy(nums, left, temp, left, right + 1 - left);
//
//        int i = left;
//        int j = mid + 1;
//
//        for (int k = left; k <= right; k++) {
//            if (i == mid + 1) {
//                nums[k] = temp[j];
//                j++;
//            } else if (j == right + 1) {
//                nums[k] = temp[i];
//                i++;
//            } else if (temp[i] <= temp[j]) {
//                // 注意写成 < 就丢失了稳定性（相同元素原来靠前的排序以后依然靠前）
//                nums[k] = temp[i];
//                i++;
//            } else {
//                // temp[i] > temp[j]
//                nums[k] = temp[j];
//                j++;
//            }
//        }
//    }
//}
