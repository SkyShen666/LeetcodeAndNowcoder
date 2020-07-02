package 位运算;

public class No_693Binary_Number_with_Alternating_Bits {
    public static void main(String[] args) {
        boolean rs = hasAlternatingBits(11);
        System.out.println(rs);
    }

    /**
     * 方法二：
     *      1010 >> 1 ==>> 0101
     *      1010 ^ 0101 ==>> 1111  每一位都不同
     * @param n
     * @return
     */
    private static boolean hasAlternatingBits(int n) {
        int a = (n ^ (n >> 1));
        return (a & (a + 1)) == 0;
    }



/*    private static boolean hasAlternatingBits(int n) {
        int temp = n & 1;
        while (n > 0){
            n = n >> 1;
            if ((n & 1) == temp){
                return false;
            }
            temp = n & 1;
        }
        return true;
    }*/
}
