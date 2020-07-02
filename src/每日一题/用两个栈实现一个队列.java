package 每日一题;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * ps: 栈：先进后出， 队列：先进先出
 * 解题思路：
 *      1、in栈来处理push操作，out栈来处理pop操作
 *      2、一个元素进入in栈之后，出栈的顺序应该反转。
 *      3、当元素出栈时，需要所有元素先进入out栈，再从out栈出来顺序就被反转了。
 */
public class 用两个栈实现一个队列 {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            try {
                throw new Exception("queue is Empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return out.pop();
    }
}
