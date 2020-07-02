package 字符串;

public class No_409Longest_Palindrome {
    public static void main(String[] args) {
        int n = longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");//5 naaan
        System.out.println(n);
    }

    /**
     * 需要偶数个
     * baaab
     * aaaaa
     * a
     *
     * @param s
     * @return
     */
    private static int longestPalindrome(String s) {
        int palindromeLen = 0;
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (int n : count) {
            //把出现奇数次和偶数次看做一样，都是偶数次
            palindromeLen = palindromeLen + (n / 2) * 2;
        }
        return palindromeLen < s.length() ? palindromeLen + 1 : palindromeLen;
    }
}
