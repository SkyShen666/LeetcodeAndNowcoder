package 排序;

/**
 * 快速排序的基本思想是基于分治法的：
 *      1、在待排序表L[1...n]中任取一个元素pivot作为基准
 *      2、通过一趟排序将待排序表划分为独立的两个部分L[1...k-1]和L[k+1...n]
 *      3、其中L[1...k-1]中所有元素小于pivot，L[k+1...n]中所有元素大于或等于pivot
 *      4、pivot放在其最终位置L[k]上
 * 以上4步操作称作为：一趟快速排序
 * 分别递归地对两个子表重复上述过程，直至每部分内只有一个元素或空为止，即所有元素都放在了其最终位置上
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2,12,4,6,87,8,1,0,-1};
        int low = 0, high = nums.length - 1;
        quickSort(nums, low, high);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotPos = partition(a, low, high);
            quickSort(a, low, pivotPos - 1);
            quickSort(a, pivotPos + 1, high);
        }
    }

    // partition 就是划分操作, 返回下标 low, 使得比 nums[low] 小的数都在 low 的左边，比 nums[low] 大的数都在 low 的右边。
    private static int partition(int[] a, int low, int high) {
        int pivot = a[low]; // 将当前表中的第一个元素设为枢轴值，对表进行划分

        while (low < high) {
            while (low < high && a[high] >= pivot) --high;
            a[low] = a[high]; // 将比枢轴值小的元素移动到左端
            while (low < high && a[low] <= pivot) ++low;
            a[high] = a[low]; // 将比枢轴值大的元素移动到右端
        }
        a[low] = pivot; // 枢轴元素存放到最终位置

        return low; // 返回存放枢轴的最终位置
    }
}
