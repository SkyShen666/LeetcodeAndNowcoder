package 数组与矩阵;

/**
 * LeetCode88
 * 解法：从后面开始确定
 */
public class No_88合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i--];
            } else {
                nums1[i + j + 1] = nums2[j--];
            }
        }
        // 如果A被剩下，它本来就在数组中且有序，就不用管了。但如果B被剩下，还需将其一一插入A中。
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
    }
}
