package 数组与矩阵;

import java.util.Scanner;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/maximize-distance-to-closest-person/solution/zhao-dao-liang-tou-lian-xu-0yi-ji-zhong-jian-lian-/
 */
public class No_849到最近的人的最大距离 {
    public int maxDistToClosest(int[] seats) {
        int cnt1 = 0, cnt2 = 0;
        int cntMid = 0, cntMidMax = 0;
        int low = 0, high = seats.length - 1;
        // cnt1记录开头连续0的个数
        while (seats[low] == 0) {
            low++;
            cnt1++;
        }
        // cnt2记录结尾连续0的个数
        while (seats[high] == 0) {
            high--;
            cnt2++;
        }
        // cntMidMax记录从第一个1到最后一个1之间，连续0的最大值
        for (int i = low; i <= high; i++) {
            if (seats[i] == 0) {
                cntMid++;
            } else {
                cntMidMax = Math.max(cntMidMax, cntMid);
                cntMid = 0;
            }
        }

        return Math.max(Math.max(cnt1, cnt2), (cntMidMax + 1) / 2);
    }
}
