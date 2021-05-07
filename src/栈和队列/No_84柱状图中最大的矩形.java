package 栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  单调栈：栈顶元素保持最大
 *  时间复杂度O(n)
 *
 *  参考题解：
 *  https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-jie-dan-diao-zhan-bi-xu-miao-dong-by-sweetie/
 */
public class No_84柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        newHeights[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            newHeights[i] = heights[i - 1];
        }
        newHeights[n + 1] = 0;

        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < newHeights.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                max = Math.max(max, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return max;
    }
}
