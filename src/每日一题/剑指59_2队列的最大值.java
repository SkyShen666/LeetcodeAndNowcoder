package 每日一题;
import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/javadui-lie-yu-shuang-duan-dui-lie-by-zackqf/
 */
public class 剑指59_2队列的最大值 {
    private Queue<Integer> queue;   // 队列：插入和删除
    private Deque<Integer> max;     // 双端队列：获取最大值

    public 剑指59_2队列的最大值() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.size() > 0 ? max.peek() : -1;     // 双端队列的队首为que的最大值
    }

    public void push_back(int value) {
        queue.offer(value);
        while (max.size() > 0 && max.peekLast() < value) {
            max.pollLast();     // 将deq队尾小于value的元素删掉
        }
        max.offerLast(value);   // 将value放在deq队尾
    }

    public int pop_front() {
        int num = queue.size() > 0 ? queue.poll() : -1;     // 获得队首元素
        if (max.size() > 0 && max.peek() == num) {
            max.poll();     // 如果出队的元素是当前最大值，将deq的队首出队
        }

        return num;
    }
}
