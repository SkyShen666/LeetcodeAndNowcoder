package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class No_21Merge_Two_Sorted_Lists_Easy {
    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    /**
     * 方法二：迭代
     *
     * public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    }
     */
}
