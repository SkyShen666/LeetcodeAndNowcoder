package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 经典滑动窗口题目
 * 剑指offer48题，查看解析
 */
public class No_3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                begin = Math.max(begin, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - begin + 1);
        }

        return maxLen;
    }
}
