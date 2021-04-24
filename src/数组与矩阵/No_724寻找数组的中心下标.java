package 数组与矩阵;

public class No_724寻找数组的中心下标 {
    // 1. leftSum + rigthSum + pivot = sum
    // 2. leftSum = rightSum
    // 3. 2 * leftSum + pivot = sum
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * leftSum + nums[i] == sum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}

    // 暴力法
//    public int pivotIndex(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//
//        int leftSum = 0, rigthSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            rigthSum = 0;
//            for (int j = nums.length - 1; j > i; j--) {
//                rigthSum += nums[j];
//            }
//            if (leftSum == rigthSum) {
//                return i;
//            }
//            leftSum += nums[i];
//        }
//
//        return -1;
//    }