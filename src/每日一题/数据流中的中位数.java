package 每日一题;

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class 数据流中的中位数 {
    //小顶堆，放置右半边的元素
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆，放置左半边的元素
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //标记已放置的元素数量
    private int cnt = 0;

    //保证大顶堆中放着的元素小于小顶堆中放着的元素
    public void Insert(Integer num) {
        //已插入的元素数量为偶数，先放入大顶堆，再将大顶堆中的最大数放入小顶堆中。
        if (cnt % 2 == 0) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            //已插入的元素数量为奇数，先放入小顶堆中，再将小顶堆中堆顶的最小元素插入到大顶堆中
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        cnt++;
    }

    public Double GetMedian() {
        if (cnt % 2 == 0) {
            return new Double((maxHeap.peek() + minHeap.peek()) / 2.0);
        } else {
            return new Double(minHeap.peek());
        }
    }
}
