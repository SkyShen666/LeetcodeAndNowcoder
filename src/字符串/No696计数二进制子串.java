package 字符串;

public class No696计数二进制子串 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int cnt = 0;
        int preLen = 0;
        int currLen = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLen++;
            } else {
                preLen = currLen;
                currLen = 1;
            }

            if (currLen <= preLen) {
                cnt++;
            }
        }

        return cnt;
    }
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