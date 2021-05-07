package 数组与矩阵;

import java.util.LinkedList;

public class No_556下一个更大元素3 {
    public int nextGreaterElement(int n) {
//        char[] a = ("" + n).toCharArray();
        // 1. 将n拆分成数组
        LinkedList<Integer> list = new LinkedList<>();
        while (n > 0) {
            list.addFirst(n % 10);
            n /= 10;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i < 0) {
            return -1;
        }

        // 2. 寻找下一个更大的排列
        int j = nums.length - 1;
        // 2.1 找出第一个不满足升序要求的（以从后向前的角度）
        while (j > i && nums[j] <= nums[i]) j--;
        // 2.2 找到并交换一个比nums[i]更大的数（同样需要最大索引，需要从后往前遍历）
        if (j > i) {
            swap(nums, i, j);
        } else { // 若(j == 0 && i == 0)说明没有下一个更大的排列！
            return -1;
        }
        // 2.3 [i+1: len - 1] 都是升序，需要改成降序，翻转即可
        reverse(nums, i + 1, nums.length - 1);

        // 3. 计算下一个更大的排列，注意数字溢出的情况
        n = 0;
        for (int num : nums) {
            // n * 10 + num > Integer.MAX_VALUE
            if (n > (Integer.MAX_VALUE - num) / 10) {
                return -1;
            }
            n = n * 10 + num;
        }
        return n;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
