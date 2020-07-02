import java.util.ArrayList;

/**
 *解法二：
 *      头插法
 *      head节点不存储值
 *      第一个节点为head节点后的节点，从这个节点开始存储数据
 */
public class Demo03_02 {
    private class ListNode {
        private int val;//每个节点的数据
        private ListNode next;//每个节点指向下一个节点的连接

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode temp = listNode.next;//定义一个temp指针，指向listNode的下一个节点
            listNode.next = head.next;//插入head链表的头部
            head.next = listNode; //成功插入
            listNode = temp;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        head = head.next;
        while (head != null){
            arr.add(head.val);
            head = head.next;
        }
        return arr;
    }
}
