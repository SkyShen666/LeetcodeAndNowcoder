package 栈和队列;

/**
 * LeetCode_42接雨水
 * 单调栈
 *  甜姨解法
 * 作者：sweetiee
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water/solution/dan-diao-zhan-jie-jue-jie-yu-shui-wen-ti-by-sweeti/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.*;

public class No_42接雨水 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int amount = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curIndex = stack.pop();
                // 若栈顶和出栈元素相等，则一直pop出去
                while (!stack.isEmpty() && height[curIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int topIndex = stack.peek();
                    // topIndex此时指向的是此次接住雨水的左边界。右边界是当前柱体，即i。
                    // Math.min(height[stackTop], height[i]) 是左右柱子高度的min，减去height[curIdx]就是雨水的高度。
                    // i - stackTop - 1 是雨水的宽度。(注意，用curIndex - stackTop 就错了，可能会少雨水)
                    amount += (Math.min(height[stack.peek()], height[i]) - height[curIndex]) * (i - topIndex - 1);
                }
            }
            stack.add(i);
        }
        return amount;
    }
}

/** 暴力法
 public int trap(int[] height) {
 if (height == null || height.length < 3) {
 return 0;
 }
 int amount = 0;
 // 寻找每个i的左右两侧能到达的最高峰
 // 包含了自己，好处就是可以减为0，不能存水的时候，左边或右边没有比自己高的，就是自己减自己 为0）
 for (int i = 1; i < height.length - 1; i++) {
 int max_left = 0, max_right = 0;
 // 左边最高峰
 for (int j = i; j >= 0; j--) {
 max_left = Math.max(max_left, height[j]);
 }
 // 右边最高峰
 for(int j = i; j < height.length; j++) {
 max_right = Math.max(max_right, height[j]);
 }
 amount += Math.min(max_left, max_right) - height[i];
 }
 return amount;
 }
 */