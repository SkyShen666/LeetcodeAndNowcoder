package 字符串;

// 参考题解：
// https://leetcode-cn.com/problems/repeated-substring-pattern/solution/jian-dan-ming-liao-guan-yu-javaliang-xing-dai-ma-s/
public class No_459重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        // str 去除首尾元素
        return str.substring(1, str.length() - 1).contains(s);
    }
}
