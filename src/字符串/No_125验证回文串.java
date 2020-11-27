package 字符串;

public class No_125验证回文串 {
    public static boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while(i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i == j) {
                return true;
            } else if (i < j) {
                char a = s.charAt(i);
                char b = s.charAt(j);
                a = Character.toLowerCase(a);
                b = Character.toLowerCase(b);
                if (a == b) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     public boolean isPalindrome(String s) {
     int n = s.length();
     StringBuilder tmp = new StringBuilder();
     for (int i = 0; i < n; i++) {
     char c = s.charAt(i);
     if (Character.isLetterOrDigit(c)) {
     tmp.append(Character.toLowerCase(c));
     }
     }

     n = tmp.length();
     int i = 0, j = n - 1;
     while (i < j) {
     if (tmp.charAt(i) != tmp.charAt(j)) {
     return false;
     }
     i++;
     j--;
     }
     return true;
     }
     * @param args
     */

    public static void main(String[] args) {
        String str = "0P";
        boolean res = isPalindrome(str);
        System.out.println(res);
    }


}
