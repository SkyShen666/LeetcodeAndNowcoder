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
    public static void main(String[] args) {

    }


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
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
    /**
     * Description:
     *  Merge two sorted linked lists and return it as a new list.
     *  The new list should be made by splicing together the nodes of the first two lists.
     * Example:
     *  Input: 1->2->4, 1->3->4
     *  Output: 1->1->2->3->4->4
     * 尾插法即可
     * @param l1
     * @param l2
     * @return
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            if (l1 == null || l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            } else if (l2 == null || l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                    p = p.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                    p = p.next;
                }
            }
        }
        return head.next;
    }
     */
}
