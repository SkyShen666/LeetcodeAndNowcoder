package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * Input:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class 字符串的排列 {
    ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] used, StringBuffer sb) {
        if (chars.length == sb.length()) {
            ret.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && chars[i - 1] == chars[i] && used[i - 1]) { //防止重复
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            backtracking(chars, used, sb);
            //回溯改为原来状态
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
