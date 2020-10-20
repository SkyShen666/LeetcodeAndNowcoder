package 链表;
import java.util.*;
public class No_143重排链表 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 存储到list中
        List<ListNode> list = new ArrayList<>();
        while(head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            // 偶数个会提前相遇
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
