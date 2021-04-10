package 哈希表;

import java.util.*;

// LRU(Least Recently Used):最近最少使用，一种常见的页面置换算法，选择最近最久未使用的页面予以淘汰。
// 参考题解：
// https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/
public class No_146LRU缓存机制 {
    // 双向链表结点类
    private class DLinkedNode {
        private int key;
        private int value;
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
    private DLinkedNode dummyHead; // 虚拟头结点，无前驱，为了方便直接找到头结点
    private DLinkedNode dummyTail; // 虚拟尾结点，无后继，为了方便直接找到尾结点
    private int capacity;

    public No_146LRU缓存机制(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        dummyHead = new DLinkedNode();
        dummyTail = new DLinkedNode();

        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    // 如果存在，把当前结点移动到双向链表的头部
    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    /**
     * 若缓存中存在，则更新数据，并将节点移到队头
     * 若缓存中不存在：1）若缓存已满，删除队尾的节点,并在缓存中(map)删除
     *                2）将新节点加入队头
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToFirst(node);
            return;
        }

        if (map.size() == capacity) {
            DLinkedNode node = removeLast();
            // DLinkedNode 结点类设计 key 就是为了在这里删除
            map.remove(node.key);
        }

        DLinkedNode node = new DLinkedNode(key, value);
        map.put(key, node);
        addFirst(node);
    }

    private void moveToFirst(DLinkedNode node) {
        remove(node);
        addFirst(node);
    }

    private void remove(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addFirst(DLinkedNode node) {
        node.next = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next.pre = node;
        dummyHead.next = node;
    }

    private DLinkedNode removeLast() {
        DLinkedNode node = dummyTail.pre;
        remove(node);
        return node;
    }
}
