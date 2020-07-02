package 数学;

import java.util.Arrays;

public class No_169Majority_Element {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,1};
        int n = majorityElement(nums);
        System.out.println(n);
    }

    /**
     * 方法二：
     * 可以利用 Boyer-Moore Majority Vote Algorithm 来解决这个问题，使得时间复杂度为 O(N)。
     * 可以这么理解该算法：
     *      使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相等时，令 cnt--。
     *      如果前面查找了 i 个元素，且 cnt == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2，
     *      因为如果多于 i / 2 的话 cnt 就一定不会为 0。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
     * @param nums
     * @return
     */
    private static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;
        for (int num : nums) {
            majority = (count == 0) ? num : majority;
            count = (num == majority) ? count + 1 : count - 1;
        }
        return majority;
    }




/*    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/
}
