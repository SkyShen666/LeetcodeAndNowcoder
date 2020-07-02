package 每日一题;

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
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 三步大法好：
 *      1、插入重复的结点
 *      2、给重复的结点安排上random指针
 *      3、拆出来
 */
public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
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
            if (cur.random != null) {
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
