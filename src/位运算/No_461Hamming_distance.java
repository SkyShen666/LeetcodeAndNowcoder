package 位运算;

public class No_461Hamming_distance {
    public static void main(String[] args) {
        int n = hammingDistance(1, 4);
        System.out.println(n);
    }

    /**
     * 方法三：用Integer.bitCount()来返回1的个数
     * @param x
     * @param y
     * @return
     */
    private static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    /**
     * 方法二：对x,y这两个数进行异或操作，每一位，相同为0，不同为1
     * @param x
     * @param y
     * @return
    private static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0){
            if ((z & 1) == 1){
                count++;
            }
            z = z >> 1;
        }
        return count;
    }
     */

/*
    *自己的方法，很笨
   private static int hammingDistance(int x, int y) {
        String strX = Integer.toBinaryString(x);
        String strY = Integer.toBinaryString(y);
        int lenX = strX.length();
        int lenY = strY.length();
        int count = 0;
        while (lenX >= 0 || lenY >= 0) {
            if (lenX == 0 && lenY == 0){
                break;
            }
            if (lenX > 0 && lenY > 0) {
                if (strX.charAt(--lenX) != strY.charAt(--lenY)) {
                    count++;
                }
            } else if (lenX == 0 && lenY > 0) {
                if (strY.charAt(--lenY) == '1') {
                    count++;
                }
            } else if (lenY == 0 && lenX > 0) {
                if (strX.charAt(--lenX) == '1') {
                    count++;
                }
            }
        }
        return count;
    }*/
}
