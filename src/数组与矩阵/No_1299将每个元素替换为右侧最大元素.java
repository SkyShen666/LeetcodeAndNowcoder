package 数组与矩阵;

/**
 * LeetCode_54(官方题解)
 *
 * 思路：逆序遍历
 * 等价于，对于arr数组中每个元素arr[i],将arr[i]替换成arr[i + 1] ... arr[n - 1] 中的最大值
 * 所以逆序地遍历整个数组，可以维护数组从右到左当前位置的最大值。
 *
 * 注意：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class No_1299将每个元素替换为右侧最大元素 {
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] res = new int[arr.length];
        res[res.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            res[i] = Math.max(res[i + 1], arr[i + 1]);
        }
        return res;
    }
}

/**  暴力法
 public int[] replaceElements(int[] arr) {
 for (int i = 0; i < arr.length - 1; i++) {
 arr[i] = findMax(arr, i + 1);
 }
 arr[arr.length - 1] = -1;
 return arr;
 }

 private int findMax(int[] arr, int begin) {
 int max = Integer.MIN_VALUE;
 for (int i = begin; i < arr.length; i++) {
 if (max < arr[i]) {
 max = arr[i];
 }
 }
 return max;
 }
 **/