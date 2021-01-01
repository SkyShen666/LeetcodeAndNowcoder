package 位运算;

public class No_371Sum_of_Two_Integers {
    public static void main(String[] args) {
        int sum = getSum(-1,2);
        System.out.println(sum);
    }

    /**
     * 此题不会
     * 此题不允许用加减法操作==>>位运算
     *        12:1100 +
     *        5 :0101
     *       17:10001
     *============================
     *          01111
     *          01111
     *          11110
     *============================
     * a ^ b 为不考虑仅为的情况下的和  即  1 + 1 = 0  但是不向上一位进1
     * a & b 为进位
     * 这俩一补，就成了！
     * @param a
     * @param b
     * @return
     */
    private static int getSum(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (carry != 0);

        return sum;
    }
}
