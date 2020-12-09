package 动态规划;
import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/letter-case-permutation/solution/shen-du-you-xian-bian-li-hui-su-suan-fa-python-dai/
 * 提示：字符串的问题的特殊之处在于，字符串的拼接生成新对象，因此在这一类问题上没有显示「回溯」的过程，
 * 但是如果使用 StringBuilder 拼接字符串就另当别论
 */
public class No_784字母大小写全排列 {
    private List<String> list;
    private String S;
    private int n;

    public List<String> letterCasePermutation(String S) {
        list = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return list;
        }

        this.S = S;
        n = S.length();
        StringBuilder str = new StringBuilder();

        dfs(0, str);

        return list;
    }

    private void dfs(int begin, StringBuilder str) {
        if (begin == n) {
            list.add(str.toString());
            return;
        }

        char c = S.charAt(begin);
        str.append(c);
        dfs(begin + 1, str);
        // 若是字母，则可以派生出一个新的分支
        if (Character.isLetter(c)) {
            str.deleteCharAt(begin);
            c = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            str.append(c);
            dfs(begin + 1, str);
        }
        str.deleteCharAt(begin);
    }
}


//    public List<String> letterCasePermutation(String S) {
//        List<String> res = new ArrayList<>();
//        int n = S.length();
//        if (n == 0) {
//            return res;
//        }
//        char[] charArray = new char[n];
//        backtrack(res, S, n, 0, charArray);
//        return res;
//    }
//
//    private void backtrack(List<String> res, String S, int n, int begin, char[] charArray) {
//        if (begin == n) {
//            res.add(new String(charArray));
//            return;
//        }
//
//        char currChar = S.charAt(begin);
//        charArray[begin] = currChar;
//        backtrack(res, S, n, begin + 1, charArray);
//
//        // 若是字母，则可以派生出一个新的分支
//        if (Character.isLetter(currChar)) {
//            // 这一步直接修改，相当于回溯
//            charArray[begin] = Character.isLowerCase(currChar) ? Character.toUpperCase(currChar) : Character.toLowerCase(currChar);
//            backtrack(res, S, n, begin + 1, charArray);
//        }
//    }