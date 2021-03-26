package 每日一题;
import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/javadui-lie-yu-shuang-duan-dui-lie-by-zackqf/
 */
public class 剑指59_2队列的最大值 {
    private Queue<Integer> queue;
    private Deque<Integer> deque; // 单调队列：由双端队列实现

    public 剑指59_2队列的最大值() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void push_back(int value) {
        // 维护单调队列
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        int num = queue.isEmpty() ? -1 : queue.poll();
        // 若移除的值为单调队列的最大值
        if (!deque.isEmpty() && deque.peekFirst() == num) {
            deque.pollFirst();
        }

        return num;
    }
}
