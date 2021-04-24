package A剑指Offer;

public class 剑指52_两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            // 注意应判断 pA 是否为 null，而不是 pA.next
            // 在两个链表没有交点时，这样 pA 和 pB 就能同时等于 null，退出循环，防止了死循环出现。
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
