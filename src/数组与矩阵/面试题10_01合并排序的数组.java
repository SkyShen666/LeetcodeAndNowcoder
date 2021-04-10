package 数组与矩阵;

public class 面试题10_01合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[i + j + 1] = A[i--];
            } else {
                A[i + j + 1] = B[j--];
            }
        }
        // 如果A被剩下，它本来就在数组中且有序，就不用管了。但如果B被剩下，还需将其一一插入A中。
        while (j >= 0) {
            A[j] = B[j--];
        }
    }
}
