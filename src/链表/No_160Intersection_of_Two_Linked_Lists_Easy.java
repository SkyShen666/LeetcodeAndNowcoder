package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) {
 *          val = x;
 *          next = null;
 *      }
 * }
 */
public class No_160Intersection_of_Two_Linked_Lists_Easy {
    public static void main(String[] args) {

    }

    /**
     * 双指针法：
     *      1、创建两个指针pA和pB,分别初始化为链表A和链表B的头结点，然后让它们逐结点遍历
     *      2、当pA到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B);
     *         类似的，当pB到达链表的尾部时，将它重定位到链表 A 的头结点。
     *      3、若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
     *      4、想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。
     *         由于 B.length (=4) < A.length (=6)，pB比pA少经过2个结点，会先到达尾部。
     *         将pB重定向到 A的头结点，pA重定向到 B 的头结点后，pB要比pA多走2个结点。因此，它们会同时到达交点。
     *      5、如果两个链表存在相交，它们末尾的结点必然相同。因此当 pA/pB到达链表结尾时，记录下链表 A/B 对应的元素。
     *         若最后元素不相同，则两个链表不相交。
     *  =====================================================================================
     * 其实总结起来就是：起点虽然不一样，但路程一样,终点一样,速度一样，必定同时到达！
     * 其中，路程是构思的关键点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            // 思考 pA.next == null 就超时了
            // null == null ==> true
            // 若用pA.next 这种判断条件,在两个链表无交点时，pA,pB永远不会指向null，就会陷入死循环。
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
