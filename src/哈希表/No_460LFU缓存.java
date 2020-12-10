package 哈希表;
import java.util.*;
// 参考题解：
// https://leetcode-cn.com/problems/lfu-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiwei/
// 需要动手画图！
public class No_460LFU缓存 {
    private class DLinkedNode {
        private int key;
        private int value;
        private int frequency = 1;
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map;
    private Map<Integer, DoubleLinkedList> frequencyMap; // 访问次数哈希表
    private Integer capacity;
    private Integer minFrequency = 1; // 全局最低访问次数，删除最少使用访问次数的结点时会用到

    public No_460LFU缓存(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        frequencyMap = new HashMap<>();
    }

    // get 一次操作，访问次数就增加 1；从原来的链表调整到访问次数更高的链表的表头
    public int get(int key) {
        if (capacity == 0) { // 测试测出来的，capacity 可能传 0
            return -1;
        }

        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            remove(node);
            // 挂接到新的访问次数的双向链表的头部
            int frequency = node.frequency;
            addFirst(frequency, node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        // 如果 key 存在，就更新访问次数 + 1，更新值
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            remove(node);
            node.value = value;
            int frequency = node.frequency;
            addFirst(frequency, node);

            return;
        }

        // 如果 key 不存在
        // 1、如果满了，先删除访问次数最小的的末尾结点，再删除 map 里对应的 key
        if (map.size() == capacity) {
            // 1、从双链表里删除结点
            DoubleLinkedList doubleLinkedList = frequencyMap.get(minFrequency);
            DLinkedNode removeNode = doubleLinkedList.removeTail();

            // 2、删除 map 里对应的 key
            map.remove(removeNode.key);
        }

        // 2、再创建新结点放在访问次数为 1 的双向链表的前面
        DLinkedNode newDLinkedNode = new DLinkedNode(key, value);
        addFirst(1, newDLinkedNode);
        map.put(key, newDLinkedNode);

        // 【注意】因为这个结点是刚刚创建的，最少访问次数一定为 1
        this.minFrequency = 1;
    }

    // 以下部分主要是结点类和双向链表的操作

    // 双向链表
    private class DoubleLinkedList {
        private DLinkedNode dummyHead;
        private DLinkedNode dummyTail;
        private int count; // 当前双向链表的有效结点数

        public DoubleLinkedList() {
            count = 0;
            this.dummyHead = new DLinkedNode();
            this.dummyTail = new DLinkedNode();

            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        // 把一个结点类添加到双向链表的开头（头部是最新使用数据）
        public void addNode2Head(DLinkedNode addNode) {
            DLinkedNode oldHead = dummyHead.next;
            // 两侧结点指向它
            dummyHead.next = addNode;
            oldHead.pre = addNode;
            // 它的前驱和后继指向两侧结点
            addNode.pre = dummyHead;
            addNode.next = oldHead;
            count++;
        }

        // 把双向链表的末尾结点删除（尾部是最旧的数据，在缓存满的时候淘汰）
        public DLinkedNode removeTail() {
            DLinkedNode oldTail = dummyTail.pre;
            DLinkedNode newTail = oldTail.pre;

            // 两侧结点建立连接
            newTail.next = dummyTail;
            dummyTail.pre = newTail;

            // 它的两个属性切断连接
            oldTail.pre = null;
            oldTail.next = null;

            // 重要：删除一个结点，当前双向链表的结点个数少 1
            count--;

            // 维护
            return oldTail;
        }
    }

    // 将原来访问次数的结点，从双向链表里脱离出来
    private void remove(DLinkedNode node) {
        DLinkedNode preNode = node.pre;
        DLinkedNode nextNode = node.next;
        // 两侧结点建立连接
        preNode.next = nextNode;
        nextNode.pre = preNode;
        // 删除去原来两侧结点的连接
        node.pre = null;
        node.next = null;

        // 维护双链表结点数
        frequencyMap.get(node.frequency).count--;

        // 【注意】维护 minFrequency
        // 如果当前结点正好在最小访问次数的链表上，并且移除以后结点数为 0，最小访问次数需要加 1
        if (node.frequency == minFrequency && frequencyMap.get(node.frequency).count == 0) {
            // 这一步需要仔细想一下，经过测试是正确的
            minFrequency++;
        }

        // 访问次数加 1
        node.frequency++;
    }

    // 把结点放在对应访问次数的双向链表的头部
    private void addFirst(int frequency, DLinkedNode addNode) {
        DoubleLinkedList doubleLinkedList;

        // 如果不存在，就初始化
        if (frequencyMap.containsKey(frequency)) {
            doubleLinkedList = frequencyMap.get(frequency);
        } else {
            doubleLinkedList = new DoubleLinkedList();
        }

        // 添加到 DoubleLinkedList 的表头
        doubleLinkedList.addNode2Head(addNode);
        frequencyMap.put(frequency, doubleLinkedList);
    }
}
