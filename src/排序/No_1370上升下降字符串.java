package 排序;

// 桶排序
// 参考题解：
// https://leetcode-cn.com/problems/increasing-decreasing-string/solution/1370java-yong-shu-zu-dai-ti-hashmapde-xian-xing-su/
public class No_1370上升下降字符串 {
    public String sortString(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }

            for (int i = 25; i >= 0; i--) {
                if (count[i] != 0) {
                    sb.append((char)('a' + i));
                    count[i]--;
                }
            }
        }
        return sb.toString();
    }
}
