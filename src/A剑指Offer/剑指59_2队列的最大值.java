package A剑指Offer;
import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/javadui-lie-yu-shuang-duan-dui-lie-by-zackqf/
 */
public class 剑指59_2队列的最大值 {
    private Queue<Integer> queue;
    private Deque<Integer> max;

    public 剑指59_2队列的最大值() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.isEmpty() ? -1 : max.peekFirst();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        int num = queue.isEmpty() ? -1 : queue.poll();
        if (!max.isEmpty() && max.peekFirst() == num) {
            max.pollFirst();
        }
        return num;
    }
}
