package 字符串;

public class No_242Valid_Anagram {
    public static void main(String[] args) {
        boolean rs = isAnagram("aba", "aab");
        System.out.println(rs);
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int n : count) {
            if (n != 0){
                return false;
            }
        }
        return true;
    }
}
