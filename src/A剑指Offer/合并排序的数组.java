package A剑指Offer;

public class 合并排序的数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        int p = m - 1, q = n - 1;
        int tmp = m + n - 1;

        while (p >= 0 && q >= 0) {
            if (A[p] >= B[q]) {
                A[tmp] = A[p];
                tmp--;
                p--;
            } else {
                A[tmp] = B[q];
                tmp--;
                q--;
            }
        }

        while (p >= 0) {
            A[tmp] = A[p];
            tmp--;
            p--;
        }

        while (q >= 0) {
            A[tmp] = B[q];
            tmp--;
            q--;
        }
    }
}
