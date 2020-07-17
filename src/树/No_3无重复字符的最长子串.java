package 树;

/**
 * LeetCode3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *"pwwkew" wke  3;
 * 经典滑动窗口题目
 */
import java.util.*;
public class No_3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        // 滑动窗口最左侧下标
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如：abcabcde 第二个窗口abc，不需要更换left。
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 更新位置，和滑动窗口长度
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
