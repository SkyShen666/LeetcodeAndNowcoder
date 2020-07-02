import java.util.ArrayList;
import java.util.List;

/**
 * 解法一：递归法
 * 要逆序打印链表1->2->3可以先逆序打印链表2->3
 * 而2->3可以看成新的链表，继而继续调用printListFromTailToHead方法
 * 链表只剩下一个节点时(3),继续调用p方法，继而无法继续下一层的调用
 * 返回上一层将节点（3）存入list集合中。。。
 */
public class Demo03 {
    private class ListNode {
        private int val;//每个节点的数据
        private ListNode next;//每个节点指向下一个节点的连接

        public ListNode(int val) {
            this.val = val;
        }
    }

    private int size;

    private ListNode head;

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(listNode != null){
            arr.addAll(printListFromTailToHead(listNode.next));
            arr.add(listNode.val);
        }
        return arr;
    }
}
