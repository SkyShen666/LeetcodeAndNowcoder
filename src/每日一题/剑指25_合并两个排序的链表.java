package 每日一题;

/**
 * 伪头结点
 */
public class 剑指25_合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}

//    递归
//
//    public ListNode Merge(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        if (list1.val < list2.val) {
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        }else {
//            list2.next = Merge(list1, list2.next);
//            return list2;
//        }
//    }
