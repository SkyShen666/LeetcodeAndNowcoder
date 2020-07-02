package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * MyStack:用队列实现栈
 *      队列：先进先出
 *       栈：先进后出
 *  每次入队，队列默认插入的位置为队尾，若想使插入的位置为队首，则需要在插入新元素后
 *  将其余元素出队，然后再入队
 *
 */
public class No_225Implement_Stack_using_Queues_Easy {

    private Queue<Integer> queue;

    public static void main(String[] args) {

    }

    /** Initialize your data structure here. */
    public No_225Implement_Stack_using_Queues_Easy() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count > 1){
            queue.add(queue.poll());
            count--;
        }
    }

    /** Removes the element on top of the stack and returns that element.
     * Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。
     * 在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null
     */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
