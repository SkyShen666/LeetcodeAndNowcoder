package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (head.next != null) {
            res.add(head.next.val);
            head = head.next;
        }
        return res;
    }
}
