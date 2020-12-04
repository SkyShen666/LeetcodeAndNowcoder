package 栈和队列;

/**
 * 单调栈
 * 参考官方题解
 * https://leetcode-cn.com/problems/next-greater-element-ii/solution/xia-yi-ge-geng-da-yuan-su-ii-by-leetcode/
 */
import java.util.*;
public class No_503下一个更大元素2 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] ret = new int[nums.length];
        // 这里可省去，提升效率，栈为空是ret[i] = -1 即可。
        // Arrays.fill(ret, -1);
        // 建立单调栈(栈顶元素最小，单调增加)
        Stack<Integer> stack = new Stack<>();
        // 第一遍循环
        traversalNums(nums, ret, stack);
        // 第二遍循环
        traversalNums(nums, ret, stack);

        return ret;
    }

    private void traversalNums(int[] nums, int[] ret, Stack<Integer> stack) {
        // 从后向前遍历（用栈所以这样方便）
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && nums[i] < stack.peek()) {
                ret[i] = stack.peek();
            } else if (stack.isEmpty()) {
                ret[i] = -1;
            }
            stack.push(nums[i]);
        }
    }
}
