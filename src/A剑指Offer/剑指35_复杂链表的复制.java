package A剑指Offer;

/**
 * public class RandomListNode {
 *  int label;
 *  RandomListNode next = null;
 * RandomListNode random = null;

 * RandomListNode(int label) {
 * this.label = label;
 * }
 * }
 */

/**
 * 三步大法好：
 *      1、插入重复的结点
 *      2、给重复的结点安排上random指针
 *      3、拆出来
 */
public class 剑指35_复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //1、复制
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        //2、安排random指针
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) { // 注意random可能指向null
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //3、拆分
        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }

        return cloneHead;
    }
}
