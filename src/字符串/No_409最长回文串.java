package 字符串;

// int[] 计数法
// 参考题解：
// https://leetcode-cn.com/problems/longest-palindrome/solution/javade-2chong-shi-xian-fang-fa-by-sweetiee/
public class No_409最长回文串 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        for (int n : cnt) {
            // 把出现奇数次和偶数次看做一样，都是偶数次。(字符出现的次数最多用偶数次)
            max = max + (n / 2) * 2;
        }

        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return max < s.length() ? max + 1 : max;
    }
}
