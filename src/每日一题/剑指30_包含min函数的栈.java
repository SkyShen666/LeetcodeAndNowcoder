package 每日一题;

import java.util.*;

/**
 * 单调栈：此单调栈非严格递减（从队头到队尾）
 * 参考题解：
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
public class 剑指30_包含min函数的栈 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public 剑指30_包含min函数的栈() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (minStack.isEmpty() || minStack.peekLast() >= x) {
            minStack.addLast(x);
        }
    }

    public void pop() {
        int num = stack.pollLast();
        if (num == minStack.peekLast()) {
            minStack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int min() {
        return minStack.peekLast();
    }
}
