package 栈和队列;

// 参考题解
// https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
public class No_32最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int max = 0;
        int[] dp = new int[len]; // 以下标i字符结尾的最长有效括号的长度

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') { // 只在s[i] = ')'时记录
                if (s.charAt(i - 1) == '(') { // ..().. 这种情况
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] >= 1 && s.charAt(i - dp[i - 1] - 1) == '(') { // ..((...))..这种情况
                    dp[i] = ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int maxLength = 0;
//        Stack<Integer> stack = new Stack<>();
//        // 栈底始终维护最后一个没有被匹配的')'右括号，这里-1假设有一个未匹配右括号
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                // 此右括号没有匹配的左括号
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    maxLength = Math.max(maxLength, i - stack.peek());
//                }
//            }
//        }
//        return maxLength;
//    }
