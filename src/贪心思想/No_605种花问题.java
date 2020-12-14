package 贪心思想;

public class No_605种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        int i = 0;

        while (i < len) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                i++;
                cnt++;
            }
            if (cnt >= n) {
                return true;
            }
            i++;
        }

        return cnt >= n;
    }
}
