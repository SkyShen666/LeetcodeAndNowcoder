package 位运算;

/**
 * Example:
 *      Input: 11111111111111111111111111111101
 *           :
 *     Output: 10111111111111111111111111111111
 */
public class No_190Reverse_Bits {
    public static void main(String[] args) {
        // you need treat n as an unsigned value
        int n = reverseBits(6);
        System.out.println(n);
    }

    /**
     * n & 1 取最后一位(注：这里的1二进制为00...01，只有 1 & 1 结果才为1，0 & 0 = 0)
     * ret |= (n & 1) 使做移一位的ret的最后一位取(n & 1)
     * @param n
     * @return
     */
    private static int reverseBits(int n) {
        int count = 0;
        int ret = 0;
        while (count < 32) {
            ret <<= 1;
            ret |= (n & 1);
            n >>= 1;
            count++;
        }
        return ret;
    }
}
