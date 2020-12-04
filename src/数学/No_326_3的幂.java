package 数学;

public class No_326_3的幂 {
    private static boolean isPowerOfThree(int n) {
        while ( n > 0 && n % 3 == 0){
            n = n / 3;
        }
        return n == 1;
    }

    /**
     * @param n
     * @return
    private static boolean isPowerOfThree(int n) {
        if (n == 0){
            return false;
        }else if (n == 1){
            return true;
        }
        while (n > 0){
            if(n % 3 != 0){
                return false;
            }else {
                n = n / 3;
                if (n == 1){
                    n = 0;
                    break;
                }
            }
        }
        return n == 0 ? true : false;
    }
     */
}
