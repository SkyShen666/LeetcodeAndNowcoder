package 数学;

public class No_633平方数之和 {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            if (i * i + j * j == c) {
                return true;
            } else if (i * i + j * j < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
