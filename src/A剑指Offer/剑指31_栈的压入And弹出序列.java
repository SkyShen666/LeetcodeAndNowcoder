package A剑指Offer;

import java.util.*;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字      !!**均不相等**!!。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 *  思路：模拟一下出栈入栈的过程，如果最后栈内还有元素说明不可。
 */
public class 剑指31_栈的压入And弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}
