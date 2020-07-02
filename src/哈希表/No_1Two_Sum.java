package 哈希表;

import java.util.HashMap;

public class No_1Two_Sum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] indices = twoSum(nums, 26);
        for (int index : indices) {
            System.out.print(index + " ");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{indexForNum.get(target - nums[i]),i};
            } else {
                indexForNum.put(nums[i],i);
            }
        }
        return null;
    }
}
