package A剑指Offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 维护两个堆：大顶堆（放置左半边元素），小顶堆（放置右半边元素）。
 *            这两个堆构成的数据流是递增排列。（大顶堆-小顶堆）
 *            共有奇数个元素时，中间的元素放置在后面的小顶堆。
 *
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
 */
public class 剑指41_数据流中的中位数 {
    //大顶堆，放置左半边的元素
    private Queue<Integer> maxHeap;
    //小顶堆，放置右半边的元素
    private Queue<Integer> minHeap;

    /** initialize your data structure here. */
    public 剑指41_数据流中的中位数() {
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 放置元素时，维持大顶堆-小顶堆 整个元素序列的递增排序。
        if (minHeap.size() == maxHeap.size()) { // 堆大小相等，放入后面的小顶堆，但先要从前面的大顶堆过渡
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {    // 堆大小不相等(minHeap.size() = maxHeap.size() + 1)，需放入前面的大顶堆，但先要从后面的小顶堆过渡
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() != maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
