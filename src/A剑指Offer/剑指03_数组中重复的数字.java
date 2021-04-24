package A剑指Offer;

/**
 * 充分利用题目条件
 * 原地交换
 * 参考题解：
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
 */
public class 剑指03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) { // 本属于自己的位置，已经有了和自己相同的值，则发现重复了。
                    return nums[i];
                } else {
                    // 若在不属于自己的位置，则把自己交换到自己的位置(若没有重复元素，遍历一次之后都会回到自己的位置)
                    swap(nums, i, nums[i]);
                }
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//    哈希表 / Set
//    public int findRepeatNumber(int[] nums) {
//        Set<Integer> dic = new HashSet<>();
//
//        for (int num : nums) {
//            if (dic.contains(num)) {
//                return num;
//            }
//            dic.add(num);
//        }
//
//        return -1;
//    }
