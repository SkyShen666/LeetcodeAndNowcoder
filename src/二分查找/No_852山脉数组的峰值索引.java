package 二分查找;

public class No_852山脉数组的峰值索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            throw new IllegalArgumentException("数组长度小于3，输入错误！");
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 利用局部单调性，逐步缩小搜索区间
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
