package 栈和队列;

import java.util.Stack;

public class No_20Valid_Parentheses_Easy {
    public static void main(String[] args) {
        boolean rs = isValid("{[]}");
        System.out.println(rs);
    }

    /**
     * 共三种括号：()、{}、[]
     *
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                boolean b = false;
                switch (stack.peek()) {
                    case '(' :
                        b = c == ')' ? true : false;
                        break;
                    case '[' :
                        b = c == ']' ? true : false;
                        break;
                    case '{' :
                        b = c == '}' ? true : false;
                        break;
                }
                if (b) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
