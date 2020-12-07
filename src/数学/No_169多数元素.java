package 数学;

/**
 * 方法二：摩尔投票法
 * 遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
 */
// 投票算法证明：
//  如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(cnt==0时发生换届选举)
//  如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
public class No_169多数元素 {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int majority = nums[0];

        for (int num : nums) {
            if (cnt == 0) {
                majority = num;
            }
            cnt += (num == majority) ? 1 : -1;
        }

        return majority;
    }


/*    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/
}
