package 动态规划;
import java.util.*;
public class No_784字母大小写全排列 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int n = S.length();
        if (n == 0) {
            return res;
        }
        char[] charArray = new char[n];
        backtrack(res, S, n, 0, charArray);
        return res;
    }

    private void backtrack(List<String> res, String S, int n, int begin, char[] charArray) {
        if (begin == n) {
            res.add(new String(charArray));
            return;
        }

        char currChar = S.charAt(begin);
        charArray[begin] = currChar;
        backtrack(res, S, n, begin + 1, charArray);

        // 若是字母，则可以派生出一个新的分支
        if (Character.isLetter(currChar)) {
            charArray[begin] = Character.isLowerCase(currChar) ? Character.toUpperCase(currChar) : Character.toLowerCase(currChar);
            backtrack(res, S, n, begin + 1, charArray);
        }
    }
}
