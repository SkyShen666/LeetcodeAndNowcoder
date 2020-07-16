package 链表;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * 方法一： 暴力法
 *      K 指针：K 个指针分别指向 K 条链表
 * 方法二：使用小顶堆优化
 *      使用小根堆对方法一进行优化，
 *      每次O(logK)比较 K个指针求min
 *      时间复杂度：O(NlogK)
 */

import java.util.*;
public class No_23合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 创建小顶堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;
    }
}

