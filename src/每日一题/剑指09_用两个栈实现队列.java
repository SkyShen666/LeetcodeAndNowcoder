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
public class 剑指09_用两个栈实现队列 {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public 剑指09_用两个栈实现队列() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

        if (out.isEmpty()) {
            return -1;
        }

        return out.pop();
    }
}
