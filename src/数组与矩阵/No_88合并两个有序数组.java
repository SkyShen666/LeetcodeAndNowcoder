package 数组与矩阵;

/**
 * LeetCode88
 * 解法：从后面开始确定
 */
public class No_88合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIndex = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 || j >= 0) {
            if( i < 0) {
                nums1[mergeIndex--] = nums2[j--];
            } else if(j < 0) {
                nums1[mergeIndex--] = nums1[i--];
            } else if(nums1[i] <= nums2[j]) {
                nums1[mergeIndex--] = nums2[j--];
            } else {
                nums1[mergeIndex--] = nums1[i--];
            }
        }
    }
}
