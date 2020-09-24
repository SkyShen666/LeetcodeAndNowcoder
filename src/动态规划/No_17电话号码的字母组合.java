package 动态规划;
import java.util.*;
public class No_17电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, digits, phoneMap, 0, new StringBuffer());
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, Map<Character, String> phoneMap, int begin, StringBuffer str) {
        if (begin == digits.length()) {
            combinations.add(str.toString());
            return;
        }

        char digit = digits.charAt(begin);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            str.append(letters.charAt(i));
            backtrack(combinations,digits, phoneMap, begin + 1, str);
            str.deleteCharAt(begin);
        }
    }
}
