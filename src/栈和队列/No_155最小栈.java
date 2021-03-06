package 栈和队列;

import java.util.*;

/**
 * 维护一个单调栈，单调非严格递减（从队头到队尾）
 * 参考题解：
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 */
public class No_155最小栈 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public No_155最小栈() {
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
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

