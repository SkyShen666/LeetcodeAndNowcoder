package 链表;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 *
 * 思路：
 * 1. 按奇偶位置拆分链表，得1->3->5->7->NULL和8->6->4->2->NULL
 * 2. 反转偶链表，得1->3->5->7->NULL和2->4->6->8->NULL
 * 3. 合并两个有序链表，得1->2->3->4->5->6->7->8->NULL
 */
public class 补充_排序奇升偶降链表 {
    private ListNode sortOddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> list = paritition(head);
        ListNode oddList = list.get(0);
        System.out.print("oddList: ");
        printList(oddList);

        ListNode evenList = reverse(list.get(1));
        System.out.print("evenList: ");
        printList(evenList);

        return merge(oddList, evenList);
    }

    private List<ListNode> paritition(ListNode head) {
         List<ListNode> list = new ArrayList<>();
         ListNode odd = head, even = head.next;
         ListNode oddHead = head, evenHead = head.next;
         while (odd.next != null && odd.next.next != null) {
             odd.next = odd.next.next;
             odd = odd.next;
             even.next = even.next.next;
             even = even.next;
         }
         odd.next = null;

         list.add(oddHead);
         list.add(evenHead);

         return list;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    private ListNode buildList(int[] nums) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = cur.next;
        }

        return dummyHead.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        补充_排序奇升偶降链表 obj = new 补充_排序奇升偶降链表();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        ListNode head = obj.buildList(nums);
        head = obj.sortOddEvenList(head);
         obj.printList(head);
    }
}
