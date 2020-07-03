package 栈和队列;

import java.util.Stack;

/**
 * MinStack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class No_155Min_Stack_Easy {

    private Stack<Integer> stack;
    // 辅助栈
    private Stack<Integer> minStack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public No_155Min_Stack_Easy() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.add(x);
        min = Math.min(min, x);
        minStack.add(min);
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

