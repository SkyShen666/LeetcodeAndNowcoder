package 每日一题;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *Solution:
 *      时间复杂度为O(n),而快排的时间复杂度为O(nlogn)
 *  此处是对快排的改进，每一趟的快排会对pivot的两边再进行递归，
 *  而这里的只会对pivot的某一侧进行递归；
 *  数据的操作量：第一轮是n，第二轮n/2，第三轮n/4，第logn轮为1
 *  2n = n + n/2 + n/4 + ... + 1  ==> O(n)
 */
public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0 || array == null)
            return 0;
        int low = 0;
        int high = array.length - 1;
        int middle = array.length / 2;
        int index = partition(array, low, high);
        while (middle != index) {
            if (middle < index) {
                high = index - 1;
                index = partition(array, low, high);
            } else {
                low = index + 1;
                index = partition(array, low, high);
            }
        }
        return checkMoreThanHalf(array,array[middle]) == true ? array[middle] : 0;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) high--;
            array[low] = array[high];
            while (low < high && array[low] <= pivot) low++;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    private boolean checkMoreThanHalf(int[] array, int result) {
        int cnt = 0;
        for (int n : array) {
            if (n == result)
                cnt++;
        }
        return cnt * 2 > array.length ? true : false;
    }
}
