package 链表;

/**
 * 双指针法：
 *      1、创建两个指针 pA 和 pB,分别初始化为 链表A 和 链表B 的头结点，然后让它们逐结点遍历
 *      2、当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B);
 *         类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
 *      3、若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
 *      4、想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。
 *         由于 B.length (=4) < A.length (=6)，pB比pA少经过2个结点，会先到达尾部。
 *         将pB重定向到 A的头结点，pA重定向到 B 的头结点后，pB要比pA多走2个结点。因此，它们会同时到达交点。
 *      5、如果两个链表存在相交，它们末尾的结点必然相同。因此当 pA/pB到达链表结尾时，记录下链表 A/B 对应的元素。
 *      6、若链表不相交，这最后两个指针走过的路程都一样，最后同时为 null，退出 while 循环， 返回null。
 *  =====================================================================================
 * 其实总结起来就是：起点虽然不一样，但路程一样,终点一样,速度一样，必定同时到达！
 * 其中，路程是构思的关键点
 */
public class No_160相交链表 {
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
