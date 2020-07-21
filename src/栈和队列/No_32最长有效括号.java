package 栈和队列;
import java.util.*;
public class No_32最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        // 栈底始终维护最后一个没有被匹配的')'右括号，这里-1假设有一个未匹配右括号
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 此右括号没有匹配的左括号
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
