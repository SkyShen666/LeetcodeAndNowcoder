package 每日一题;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class 左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0)
            return "";
        if (n >= str.length() || n < 0)
            return str;
        int len = str.length();
        char[] chars = str.toCharArray();
        //反转整个字符串
        Reverse(chars, 0, len - 1);
        //分别反转 两个子字符串
        Reverse(chars, 0, len - 1 - n);
        Reverse(chars, len - n, len - 1);
        return new String(chars);
    }

    private void Reverse(char[] chars, int pBegin, int pEnd) {
        while (pBegin < pEnd)
            swap(chars, pBegin++, pEnd--);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
