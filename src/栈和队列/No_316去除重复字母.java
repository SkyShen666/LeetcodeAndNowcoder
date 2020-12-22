package 栈和队列;
import java.util.*;
// 单调栈
// 参考题解：
// https://leetcode-cn.com/problems/remove-duplicate-letters/solution/zhan-by-liweiwei1419/
public class No_316去除重复字母 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        StringBuilder str = new StringBuilder();

        // 1.统计每个字母最后出现的位置
        for (int i = 0; i < n; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new LinkedList<>();
        boolean[] visited = new boolean[26];

        // 2. 通过遍历字符串，使用单调栈维护字典序最小的字符串
        for (int i = 0; i < n; i++) {
            char c = charArray[i];
            if (visited[c - 'a']) {
                continue;
            }

            // 在 ① 栈非空，② 当前元素字典序 < 栈顶元素，并且 ③ 栈顶元素在以后还会出现，弹出栈元素
            while (!stack.isEmpty() && c < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                char top = stack.removeLast();
                // 注意维护visited数组
                visited[top - 'a'] = false;
            }

            stack.addLast(c);
            visited[c - 'a'] = true;
        }

        for (char c : stack) {
            str.append(c);
        }

        return str.toString();
    }
}
