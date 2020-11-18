package 数学;

public class No_367Valid_Perfect_Square {
    public static void main(String[] args) {
        boolean result = isPerfectSquare(16);
        System.out.println(result);
    }

     // (n + 1)^2 - n^2 = 2n + 1
     // 4 = 1 + 3           其中 3 = 2*1 + 1
     // 9 = 1 + 3 + 5            5 = 2*2 + 1
     // 16 = 1 + 3 + 5 + 7       7 = 2*3 + 1
    private static boolean isPerfectSquare(int num) {
        int subNum = 1;
        while (num > 0){
            num -= subNum;
            subNum += 2;
        }
        return num == 0;
    }
}
