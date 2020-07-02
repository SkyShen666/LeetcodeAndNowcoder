package 每日一题;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1到n中1出现的次数）。
 */
public class 从1到n整数中出现1的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        //假设n = xyzdabc
        for (int k = 1; k <= n; k *= 10) {
            int xyzd = n / k;
            int abc = n % k;
            int d = xyzd % 10;
            int xyz = xyzd / 10;

            cnt += xyz * k;
            if (d > 1)
                cnt += k;
            if (d == 1)
                cnt += abc + 1;

            if (xyz == 0)
                break;
        }
        return cnt;
    }
}
