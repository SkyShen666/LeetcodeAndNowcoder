package 每日一题;
import java.util.*;

public class 剑指_03数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            // 交换至对应索引位置
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }

        return -1;
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
