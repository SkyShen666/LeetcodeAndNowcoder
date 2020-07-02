package 数学;

import java.util.Arrays;

public class No_462最少移动次数使数组元素相等II {
    //相遇问题，移动距离最小的方式是所有元素都移动到中位数
    //设m为中位数，若a <= m <= b, 则若想使a，b都化为m，需要的步数为(m-a) + (b - m) 即 b - a
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums.length - 1;
        int moveCnt = 0;
        while (l < h) {
            moveCnt += nums[h] - nums[l];
            l++;
            h--;
        }
        return moveCnt;
    }
}
