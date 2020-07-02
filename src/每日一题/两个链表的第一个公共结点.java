package 每日一题;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 *（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != null) {
            p1 = p1.next;
            len1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            len2++;
        }
        int cnt = Math.abs(len1 - len2);
        return len1 > len2 ? FindFirstCommonNode(pHead1, pHead2, cnt)
                : FindFirstCommonNode(pHead2, pHead1, cnt);
    }

    private ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2, int cnt) {
        while (cnt-- > 0) {
            pHead1 = pHead1.next;
        }
        while (pHead1 != pHead2 && pHead1 != null && pHead2 != null) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
