package 排序;

import java.util.PriorityQueue;

public class No_215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int pivotPos = partition(nums, low, high);
            if (pivotPos == k) {
                break;
            } else if (pivotPos < k) {
                low = pivotPos + 1;
            } else {
                high = pivotPos - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) --high;
            a[low] = a[high];
            while (low < high && a[low] <= pivot) ++low;
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
}
/*
堆：时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //构建一个小顶堆
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
 */