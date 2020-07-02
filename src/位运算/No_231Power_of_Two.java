package 位运算;

public class No_231Power_of_Two {
    public static void main(String[] args) {
        boolean rs =  isPowerOfTwo(3);
        System.out.println(rs);
    }

    /**
     * 方法三：运用&运算 1100
     *                 1011
     *                 1000
     * 复习：
     * &运算，只有当两个数都为1时结果才为1
     * |运算，只有当两个数都为0时结果才为0
     * ^异或运算，两个数相同为0，相异为1
     * ~非运算，1变0 ，0变1
     * 此题运用原理：
     *       1000
     *       0111
     * &运算:0000
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    /**
     *方法二：bitCount
     * @param n
     * @return

    private static boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
     */

/*
*自己写的方法
    private static boolean isPowerOfTwo(int n) {
        if (n == 1){
            return true;
        }else if (n < 1) {
            return false;
        } else if (n % 2 != 0) {
            return false;
        }
        while (n != 1){
            if (n % 2 != 0){
                return false;
            }
            n = n / 2;
        }
        return true;
    }
*/

}
