package 每日一题;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *       非递减数列：对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * Solution:
 *     1、非递减数组的第一个元素一定小于等于最后一个元素
 *     2、用二分查找法
 *     3、注意特殊情况，有重复的元素，例如：11101
 *
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0, h = array.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (array[l] == array[mid] && array[mid] == array[h]) {
                return minNumber(array, l, h);
            }
            if (array[mid] <= array[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return array[l];
    }

    private int minNumber(int[] array, int l, int h) {
        for (int i = l; i < h; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[l];
    }
}
