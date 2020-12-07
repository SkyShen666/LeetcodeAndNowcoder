package 链表;

import java.util.Arrays;

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
 * 方法三：两两合并，逐一合并两条链表
 *      时间复杂度：O(NK)
 * 方法四：两两合并对方法三进行优化（递归、迭代）
 *      时间复杂度：O(NlogK)
 */


// 两两合并优化（递归，分治）
// 参考题解：
// （推荐）（https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/duo-tu-yan-shi-23-he-bing-kge-pai-xu-lian-biao-by-/
// https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/4-chong-fang-fa-xiang-jie-bi-xu-miao-dong-by-sweet/
public class No_23合并K个排序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    // 通过mid将数组一分为二，并不断缩小规模，当规模为1时返回并开始合并
    // 通过合并两个链表，不断增大其规模，整体看就是不断缩小-最后不断扩大的过程
    private ListNode merge(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }

        int mid = low + (high - low) / 2;

        ListNode l1 = merge(lists, low, mid);
        ListNode l2 = merge(lists, mid + 1, high);

        return merge2Lists(l1, l2);
    }

    //合并两个有序链表
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }
}

    /*// 两两合并，迭代
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i += 2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = merge2Lists(lists[i], lists[i + 1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }*/


//  方法二：使用小顶堆优化
/*    public ListNode mergeKLists(ListNode[] lists) {
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
    }*/
