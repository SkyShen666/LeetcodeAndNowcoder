package 每日一题;
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
        return max.size() > 0 ? max.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while (max.size() > 0 && max.peekLast() < value) {
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        int num = queue.size() > 0 ? queue.poll() : -1;
        if (max.size() > 0 && max.peek() == num) {
            max.poll();
        }

        return num;
    }
}
