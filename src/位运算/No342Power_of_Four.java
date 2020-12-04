package 位运算;

/**
 * Description:
 *    Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 ===========================
 Example 1:
    Input: 16
    Output: true
 ===========================
 Example 2:
    Input: 5
    Output: false
 ===========================
 Follow up: Could you solve it without loops/recursion?
 */
public class No342Power_of_Four {
    public boolean isPowerOfFour(int num) {
        while (num > 0 && num % 4 == 0) {
            num = num / 4;
        }
        return num == 1;
    }

    /**
     * 运用正则表达式
     * Integer.toString(int i, int radix):radix为进制的意思
     * @param num
     * @return

    private static boolean isPowerOfFour(int num) {
        String str = Integer.toString(num,4);
        System.out.println(str);
        return Integer.toString(num,4).matches("10*");
    }
     */

    /**
     * 1 4 16 64 256 4
     * 尾数：4 6 4 6
     * 8 : 1000
     *
     * @param num
     * @return
    private static boolean isPowerOfFour(int num) {
        int temp = num;
        temp = temp > 10 ? temp % 10 : temp;
        return (num == 1 || (num >= 4 && (num & (num - 1)) == 0) && ((temp == 4 || temp == 6)));
    }
     */
}
