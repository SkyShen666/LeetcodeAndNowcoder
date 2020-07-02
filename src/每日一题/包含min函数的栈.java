package 每日一题;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class 包含min函数的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        //minStack每次入栈的元素若不为最小值则入栈元素替换为最小值
        minStack.push(minStack.isEmpty() ? node : Math.min(node, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        //同步出栈，不影响栈的最小值
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
