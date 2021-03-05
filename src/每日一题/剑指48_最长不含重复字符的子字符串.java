package 每日一题;

import java.util.*;

/**
 * 经典滑动窗口题目
 * HashMap存储遍历过的元素
 */
public class 剑指48_最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int begin = 0; // 滑动窗口最左侧下标
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如：abccbade 第二个窗口cba，到b时(map中已放置b，在第一个窗口abc时)，不需要更换begin, 不被已放入map中，旧的元素影响。
                begin = Math.max(begin, map.get(c) + 1);
            }
            // 更新位置，和滑动窗口长度
            map.put(c, i);
            maxLen = Math.max(maxLen, i - begin + 1);
        }

        return maxLen;
    }
}
