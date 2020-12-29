package 树;

import java.util.*;

/**
 * 经典滑动窗口题目
 * HashMap存储遍历过的元素
 */
public class No_3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0; // 滑动窗口最左侧下标
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如：abccbade 第二个窗口cba，到b时，不需要更换begin, 不被已放入map中，旧的因素影响
                begin = Math.max(begin, map.get(s.charAt(i)) + 1);
            }
            // 更新位置，和滑动窗口长度
            map.put(s.charAt(i), i);
            max = Math.max(max, i - begin + 1);
        }

        return max;
    }
}
