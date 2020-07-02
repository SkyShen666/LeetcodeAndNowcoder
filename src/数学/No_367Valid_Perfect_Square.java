package 数学;

public class No_367Valid_Perfect_Square {
    public static void main(String[] args) {
        boolean result = isPerfectSquare(16);
        System.out.println(result);
    }

    /**
     * 1 = 1 * 1  差值
     * 4 = 2 * 2   3
     * 9 = 3 * 3   5
     * 16 = 4 * 4  7
     * 25 = 5 * 5  9
     * 36 = 6 * 6  11
     * 49 = 7 * 7  13
     * 64 = 8 * 8  15
     * 81 = 9 * 9  17
     * 100 = 10 * 10 19
     * @param num
     * @return
     */
    private static boolean isPerfectSquare(int num) {
        int subNum = 1;
        while (num > 0){
            num -= subNum;
            subNum += 2;
        }
        return num == 0;
    }
}
