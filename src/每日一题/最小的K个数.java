package 每日一题;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        if (input.length == 0 || input == null || input.length < k)
            return array;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : input)
            minHeap.add(n);
        for (int i = 0; i < k; i++)
            array.add(minHeap.poll());
        return array;
    }
}
