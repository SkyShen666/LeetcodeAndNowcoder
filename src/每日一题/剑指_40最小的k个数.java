package 每日一题;

import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
 * 此处应用快排的，快速划分思想，时间复杂度为 O(n), 关于时间复杂度的分析，可参考题解
 * 快排的时间复杂度为 O(NlogN)
 */
public class 剑指_40最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            return new int[0];
        }

        int low = 0, high = arr.length - 1;

        // 最后一个参数表示我们要找的是下标为 k-1 的数
        return quickSearch(arr, low, high, k - 1);
    }

    private int[] quickSearch(int[] arr, int low, int high, int k) {
        // 每快排切分1次，找到排序后下标为 pivotPos 的元素，如果 pivotPos 恰好等于k就返回 pivotPos 以及 pivotPos 左边所有的数；
        int pivotPos = partition(arr, low, high);
        if (pivotPos == k) {
            return Arrays.copyOf(arr, pivotPos + 1);
        }

        // 否则根据下标 pivotPos 与 k 的大小关系来决定继续切分左段还是右段。
        return pivotPos > k ? quickSearch(arr, low, pivotPos - 1, k) : quickSearch(arr, pivotPos + 1, high, k);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;

        return low;
    }
}

//    小顶堆
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (arr == null || arr.length < k) {
//            return new int[0];
//        }
//
//        int[] ret = new int[k];
//        Queue<Integer> minHeap = new PriorityQueue<>();
//
//        // 构建小顶堆
//        for (int a : arr) {
//            minHeap.add(a);
//        }
//        // 取出小顶堆的前k个元素
//        for (int i = 0; i < k; i++) {
//            ret[i] = minHeap.poll();
//        }
//
//        return ret;
//    }
