package 栈和队列;

import java.util.Stack;

/**
 * MyQueue:用栈实现队列
 *      队列：先进先出
 *       栈：先进后出
 *  若用栈实现队列，只需要用两次栈就可实现，两次使用栈既可以将顺序反转过来
 *
 */
public class No_232Implement_Queue_using_Stacks_Easy {

    private Stack<Integer> in;
    private Stack<Integer> out;

    /** Initialize your data structure here. */
    public No_232Implement_Queue_using_Stacks_Easy() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        inToOut();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        inToOut();
        return out.peek();
    }

    private void inToOut() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty() && out.empty();
    }


    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
