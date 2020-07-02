package 数学;

public class No_238除自身以外数组的乘积 {
    //乘积 = 当前元素左边的乘积 * 当前元素右边的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        //此时保存的为当前元素左边的乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }

        k = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            res[i] = k * res[i];
            k = k * nums[i];
        }
        return res;
    }
}
