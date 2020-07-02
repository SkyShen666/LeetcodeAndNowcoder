package 数学;

import java.util.Arrays;

public class No_628Maximum_Product_of_Three_Numbers {
    public static void main(String[] args) {
        int[] nums = {-10,-10,3,4,5};
        int n = maximumProduct(nums);
        System.out.println(n);
    }

    /**
     * 方法二：线性扫描
     * 只需找出最小的两个数，以及最大的三个数即可
     * @param nums
     * @return
     */
    private static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= min1){
                min2 = min1;
                min1 = num;
            }else if (num < min2) {
                min2 = num;
            }
            if (num >= max3) {
                max1 = max2;
                max2 = max3;
                max3 = num;
            } else if (num >= max2) {
                max1 = max2;
                max2 = num;
            } else if (num > max1) {
                max1 = num;
            }
        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }



/*    private static int maximumProduct(int[] nums) {
        int len = nums.length - 1;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[len],nums[len] * nums[len - 1] * nums[len - 2]);
    }*/
}
