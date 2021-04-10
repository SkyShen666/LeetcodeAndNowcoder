package 字符串;

/**
 * 注意：是构造！通过这些字母构造成的最长的回文串。
 * 解题方法：(计数法)
 *      int[] cntArray = new int[58];
 *      刚开始不知道为什么要58的数组，大小写字母只有52个，后来查阅了一下ASCII编码表，原来大小写字母之间有好几个特殊字符。
 * 参考题解：
 * https://leetcode-cn.com/problems/longest-palindrome/solution/javade-2chong-shi-xian-fang-fa-by-sweetiee/
 */
public class No_409最长回文串 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int[] cntArray = new int[58];
        for (char c : s.toCharArray()) {
            cntArray[c - 'A']++;
        }
        for (int cnt : cntArray) {
            // 把出现奇数次和偶数次看做一样，都是偶数次。(字符出现的次数最多用偶数次)，若为奇数次：1 / 2 = 0, 3 / 2 = 1...
            max += (cnt / 2) * 2;
        }

        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return max < s.length() ? max + 1 : max;
    }
}
