package 每日一题;

import java.util.*;

/**
 * 经典滑动窗口题目
 * HashMap存储遍历过的元素
 */
public class 剑指48_最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(); // HashMap存储遍历过的元素
        int maxLen = 0; // 记录滑动窗口最大长度
        int begin = 0; // 滑动窗口最左侧下标

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // 是否更新滑动窗口起点begin的位置
                // 不更新begin如：abccbade 第二个窗口cba，到b时(map中已放置b，在第一个窗口abc时)，不需要更换begin, 不被已放入map中的、旧的元素影响。
                begin = Math.max(begin, map.get(c) + 1);
            }
            // 在HashMap中更新此次遍历到的元素
            map.put(c, i);
            // 更新 滑动窗口长度
            maxLen = Math.max(maxLen, i - begin + 1);
        }

        return maxLen;
    }
}
