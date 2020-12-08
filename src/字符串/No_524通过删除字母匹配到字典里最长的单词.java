package 字符串;
import java.util.*;

// 参考题解：
// https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/solution/kan-si-bu-fu-za-qi-shi-zhen-de-bu-fu-za-by-uygn9i8/
public class No_524通过删除字母匹配到字典里最长的单词 {
    public String findLongestWord(String s, List<String> d) {
        String str = "";

        for (String word : d) {
            for (int i = 0, j = 0; i < s.length() && j < word.length(); i++) {
                if (s.charAt(i) == word.charAt(j)) {
                    j++;
                }
                if (j == word.length()) {
                    if (word.length() > str.length() || (word.length() == str.length() && str.compareTo(word) > 0))
                        str = word;
                }
            }
        }

        return str;
    }
}
