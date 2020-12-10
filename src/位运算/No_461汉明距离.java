package 位运算;

// 方法二：对x,y这两个数进行异或操作，每一位，相同为0，不同为1
public class No_461汉明距离 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int cnt = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                cnt++;
            }
            num = num >> 1;
        }

        return cnt;
    }
}

//    方法三：用Integer.bitCount()来返回1的个数
//
//    private static int hammingDistance(int x, int y) {
//        return Integer.bitCount(x ^ y);
//    }


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
