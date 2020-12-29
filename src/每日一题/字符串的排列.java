package 每日一题;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * Input:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class 字符串的排列 {
    private List<String> list;
    private char[] charArr;
    private int n;
    private boolean[] used;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        charArr = s.toCharArray();
        Arrays.sort(charArr);   // 排序方便去重
        n = s.length();
        used = new boolean[n];
        list = new LinkedList<>();
        StringBuilder path = new StringBuilder();

        dfs(0, path);

        return list.toArray(new String[0]);
    }

    private void dfs(int begin, StringBuilder path) {
        if (begin == n) {
            list.add(path.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                if (i > 0 && charArr[i - 1] == charArr[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                path.append(charArr[i]);
                dfs(begin + 1, path);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }
}
