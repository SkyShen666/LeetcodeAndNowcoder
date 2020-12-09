package 动态规划;

import java.util.*;

public class No_17电话号码的字母组合 {
    private List<String> list;
    private String digits;
    private int n;
    private Map<Character, String> map;

    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        this.digits = digits;
        n = digits.length();
        map = new HashMap<>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        StringBuilder str = new StringBuilder();

        dfs(0, str);

        return list;
    }

    private void dfs(int begin, StringBuilder str) {
        if (begin == n) {
            list.add(str.toString());
            return;
        }

        char digit = digits.charAt(begin);
        String letters = map.get(digit);

        for (char c : letters.toCharArray()) {
            str.append(c);
            dfs(begin + 1, str);
            str.deleteCharAt(begin);
        }
    }
}