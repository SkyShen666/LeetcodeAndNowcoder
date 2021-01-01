package 每日一题;

/**
 *  双指针法
 *  参考题解：
 *  https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
 *  看动图即可
 */
public class 翻转单词顺序列 {
    public String reverseWords(String s) {
        s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder str = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            str.append(s.substring(i + 1, j + 1) + ' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        // 不要忘记最后再一次除去空格
        return str.toString().trim();
    }
}
