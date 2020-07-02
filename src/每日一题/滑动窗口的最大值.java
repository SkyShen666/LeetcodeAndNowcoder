package 每日一题;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class 滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        //建立大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < size; i++) {
            maxHeap.add(num[i]);
        }
        ret.add(maxHeap.peek());

        //滑动窗口开启
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            maxHeap.remove(num[i]); //脱离了滑动窗口
            maxHeap.add(num[j]); //新加入滑动窗口
            ret.add(maxHeap.peek()); //新滑动窗口的最大值
        }
        return ret;
    }
}
