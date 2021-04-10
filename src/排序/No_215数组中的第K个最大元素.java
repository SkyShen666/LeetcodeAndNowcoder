package 排序;

import java.util.PriorityQueue;

/**
 * 方法一：基于快排
 * 情况是最坏的，时间代价是 O(n ^ 2)
 *。我们可以引入随机化来加速这个过程，它的时间代价的期望是 O(n)
 */
public class No_215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return 0;
        }

        k = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int low, int high, int k) {
        int pivotPos = partition(nums, low, high);
        if (k == pivotPos) {
            return nums[k];
        }

        return pivotPos > k ? quickSort(nums, low, pivotPos - 1, k) : quickSort(nums, pivotPos + 1, high, k);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;

        return low;
    }
}
/*
堆：时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>(); //构建一个小顶堆
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
 */