package 每日一题;

public class No_bytedance {
    public static int maxDistToClosest(int[] seats) {
        int count1 = 0;
        int count2 = 0;
        int i = 0, j = seats.length - 1;
        // count1记录开头连续0的个数
        while (seats[i] == 0) {
            count1++;
            i++;
        }
        // count2记录结尾连续0的个数
        while (seats[j] == 0) {
            count2++;
            j--;
        }
        // countmax记录从第一个1到最后一个1之间，连续0的最大值
        int countmid = 0, countmax = 0;
        for (int k = i + 1; k <= j; k++) {
            if (seats[k] == 0) {
                countmid++;
            } else {
                countmax = Math.max(countmax, countmid);
                countmid = 0;
            }
        }
        // 返回count1, count2, (countmax+1)/2三者中最大值
        return Math.max((count1 + count2 + 1) / 2, (countmax + 1) / 2);
    }

    public static void main(String[] args) {
//        int[] seats = {0,0,1,0,0,0,0,1,0,0,0,0};
        int[] seats = {0,0,0,0,0,1,0,0};
        int num = maxDistToClosest(seats);
        System.out.println(num);
    }
}
