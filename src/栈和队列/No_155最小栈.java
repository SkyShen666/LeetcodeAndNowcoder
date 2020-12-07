package 栈和队列;

import java.util.*;

/**
 * MinStack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class No_155最小栈 {
    private Deque<Integer> stack;
    private Deque<Integer> minStack; // 辅助栈：只存最小值
    private int min;

    /** initialize your data structure here. */
    public No_155最小栈() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
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

