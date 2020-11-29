package 字符串;
import java.util.*;

public class No_345反转字符串中的元音字母 {
    private static final Set<Character> set = new HashSet<>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int i = 0, j = len - 1;
        char[] arr = new char[len];
        while (i <= j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            // 先找到前边的元音字母，找到了再从后往前找后面的元音字母
            if (!set.contains(a)) {
                arr[i] = a;
                i++;
            } else if (!set.contains(b)) {
                arr[j] = b;
                j--;
            } else {
                arr[i] = b;
                arr[j] = a;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
