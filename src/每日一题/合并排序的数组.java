package 每日一题;

public class 合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int p = m-1;
        int q = n-1;
        int temp = n + m - 1;
        while ( p >= 0 && q >= 0) {
            if (A[p] >= B[q]) {
                A[temp--] = A[p--];
            } else {
                A[temp--] = B[q--];
            }
        }
        while (p >= 0) {
            A[temp--] = A[p--];
        }
        while (q >= 0) {
            A[temp--] = B[q--];
        }
    }
}
