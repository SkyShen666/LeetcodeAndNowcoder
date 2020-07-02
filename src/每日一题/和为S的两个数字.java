package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Description：
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Output:
 *  对应每个测试案例，输出两个数，小的先输出。
 *  分析：
 *      使用收尾两个指针，规律是若两个数和相同，相差大的两个数乘积最小，
 *      所以收尾指针依次向内搜索，遇到两个数的和与sum相同，直接返回即可。
 */
public class 和为S的两个数字 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int p = 0, q = array.length - 1;
        while (p < q) {
            int cur = array[p] + array[q];
            if (cur == sum)
                return new ArrayList<Integer>(Arrays.asList(array[p], array[q]));
            else if (cur < sum)
                p++;
            else
                q--;
        }
        return new ArrayList<Integer>();
    }
}
