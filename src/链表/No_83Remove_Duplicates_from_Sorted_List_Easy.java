package 链表;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class No_83Remove_Duplicates_from_Sorted_List_Easy {
    public static void main(String[] args) {

    }

    /**
     * Descripiton:
     *  Given a sorted linked list, delete all duplicates such that each element appear only once.
     * Example1:
     *  Input: 1->1->2
     *  Output: 1->2
     * Example2:
     *  Input: 1->1->2->3->3
     *  Output: 1->2->3
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
