package 字符串;

public class No696Count_Binary_Substrings {
    public static void main(String[] args) {
        int n = countBinarySubstrings("10101");
        System.out.println(n);
    }

    /**
     * 方法二
     * @param s
     * @return
     */
    private static int countBinarySubstrings(String s) {
        int preLen = 0 , curLen = 1 , count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                preLen = curLen;
                curLen = 1;
            }
            if (preLen >= curLen) {
                count++;
            }
        }
        return count;
    }




/*    private static int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = count + binarySubstring(s, i, s.charAt(i));
        }
        return count;
    }

    private static int binarySubstring(String s, int i, char c) {
        int count = 0;
        int n = c - '0';
        while (s.charAt(i) == c && i < s.length()) {
            count++;
            i++;
            if (i >= s.length()) {
                return 0;
            }
        }
        int j = i;
        char k = (char) (~(n - 2) + '0');
        while (s.charAt(j) == k && count > 0) {
            count--;
            j++;
            if (j >= s.length()) {
                break;
            }
        }
        return count == 0 ? 1 : 0;
    }*/
}
