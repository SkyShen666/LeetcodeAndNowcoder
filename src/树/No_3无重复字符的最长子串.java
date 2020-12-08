package 树;

/**
 * 经典滑动窗口题目
 */
import java.util.*;
public class No_3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0; // 滑动窗口最左侧下标
        int max = 0;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如：abcabcde 第二个窗口abc，不需要更换left。
                begin = Math.max(begin, map.get(s.charAt(i)) + 1);
            }
            // 更新位置，和滑动窗口长度
            map.put(s.charAt(i), i);
            max = Math.max(max, i - begin + 1);
        }

        return max;
    }
}
