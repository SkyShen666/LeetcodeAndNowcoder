package 数学;

import java.util.*;

// 蓄水池算法
public class No_382链表随机节点_蓄水池 {
    private List<Integer> list;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public No_382链表随机节点_蓄水池(ListNode head) {
        list = new ArrayList<>();
        ListNode curNode = head;
        while(curNode != null) {
            list.add(curNode.val);
            curNode = curNode.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int i = new Random().nextInt(list.size());
        return list.get(i);
    }
}
