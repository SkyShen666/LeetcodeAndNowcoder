package 位运算;


/**
 * 方法二：将n右移一位异或n，检查结果是否全为1。
 * 1010 >> 1 ==>> 0101
 * 1010 ^ 0101 ==>> 1111  每一位都不同
 */
public class No_693交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int tmp = (n ^ (n >> 1));
        return (tmp & (tmp + 1)) == 0;
    }
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

