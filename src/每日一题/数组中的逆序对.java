package 每日一题;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 例如：{7，5，6，4} 中共5个逆序对：{7,6}、{7，5}、{7，4}、{6，4}、{5，4}
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * Input Description：
 * 题目保证输入的数组中没有的相同的数字,数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * Case:
 * Input: 1,2,3,4,5,6,7,0
 * output:7
 * <p>
 * //考察点：归并排序
 */
public class 数组中的逆序对 {
    private long cnt = 0;
    private int[] temp; //辅助数组，应设置在merge()递归函数外面

    public int InversePairs(int[] array) {
        temp = new int[array.length];
        MergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void Merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1, k = low;
        for (k = low; k <= high; k++) //注意copyOfRange(temp, low, high + 1)返回的数组下标从0开始就错误了
            temp[k] = nums[k];
        k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            }
            else {
                nums[k++] = temp[j++];
                cnt += mid - i + 1; //temp[i] > temp[j] 说明temp[i...mid]都大于temp[j]
            }
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= high) nums[k++] = temp[j++];
    }


    private void MergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        MergeSort(nums, low, mid);
        MergeSort(nums, mid + 1, high);
        Merge(nums, low, mid, high);
    }
}
