package 字符串;

public class No_9Palindrome_Number {
    public static void main(String[] args) {
        boolean rs = isPalindrome(10);
        System.out.println(rs);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int len = 0;
        int[] array = new int[10];
        while (x > 0){
            array[len++] = x % 10;
            x = x / 10;
        }
        for (int i = 0; i < len / 2; i++){
            if (array[i] != array[len-i-1]) {
                return false;
            }
        }
        return true;
    }
}
