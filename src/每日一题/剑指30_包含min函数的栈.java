package 每日一题;

import java.util.*;

/**
 * 单调栈：此单调栈非严格递减（从队头到队尾）
 * 参考题解：
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
public class 剑指30_包含min函数的栈 {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public 剑指30_包含min函数的栈() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int num = stack.pop();
        if (num == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
