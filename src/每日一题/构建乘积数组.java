package 每日一题;

import java.util.ArrayList;
/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，
 *           B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int product = 1;
        for (int i = 0; i <n; i++) {   //从左往右累乘
            B[i] = product;
            product *= A[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= product;
            product *= A[i];
        }
        return B;
    }
}
