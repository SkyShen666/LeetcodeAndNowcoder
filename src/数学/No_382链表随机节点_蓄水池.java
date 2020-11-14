package 数学;

import java.util.*;

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
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}
