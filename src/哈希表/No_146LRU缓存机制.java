package 哈希表;

import java.util.*;

// LRU(Least Recently Used):最近最少使用，一种常见的页面置换算法，选择最近最久未使用的页面予以淘汰。
// 参考题解：
// https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/
public class No_146LRU缓存机制 {
    // 双链表结点类
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

    private DLinkedNode dummyHead; // 虚拟头结点，无前驱
    private DLinkedNode dummyTail; // 虚拟尾结点，无后继
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int capacity;

    public No_146LRU缓存机制(int capacity) {
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

    // 若缓存(哈希表)的容量满了,就要删除一个链表末尾元素，然后在链表头部插入新元素
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToFirst(node);
            return;
        }

        if (map.size() == capacity) {
            DLinkedNode lastNode = removeLast();
            // DLinkedNode 结点类设计 key 就是为了在这里删除
            map.remove(lastNode.key);
        }

        DLinkedNode node = new DLinkedNode(key, value);
        map.put(key, node);
        addFirst(node);
    }

    private void addFirst(DLinkedNode node) {
        node.next = dummyHead.next;
        node.pre = dummyHead;
        dummyHead.next.pre = node;
        dummyHead.next = node;
    }

    private void remove(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToFirst(DLinkedNode node) {
        remove(node);
        addFirst(node);
    }

    private DLinkedNode removeLast() {
        DLinkedNode node = dummyTail.pre;
        remove(node);

        return node;
    }
}
