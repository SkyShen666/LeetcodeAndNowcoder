package 哈希表;

import java.util.*;

/**
 * 参考题解：
 * https://leetcode-cn.com/problems/lfu-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiwei/
 * LFU:  在一段时间内
 * 1) 先看频率（访问次数）
 * 2) 再看时间先后
 */
public class No_460LFU缓存 {
    private class DLinkedNode {
        private int key;
        private int value;
        private int frequency = 1;
        private DLinkedNode pre;
        private DLinkedNode next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DLinkedNode> map;
    private Map<Integer, DoubleLinkedList> frequencyMap;
    private int capacity;
    private int minFrequency = 1;

    public No_460LFU缓存(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!map.containsKey(key)) { // 1. 若不存在，直接返回-1
            return -1;
        }
        DLinkedNode node = map.get(key);
        deleteNode(node);
        node.frequency++;
        insertToHead(node.frequency, node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            deleteNode(node);
            node.value = value;
            node.frequency++;
            map.put(key, node);
            insertToHead(node.frequency, node);
            return;
        }
        if (map.size() == capacity) {
            DoubleLinkedList doubleLinkedList = frequencyMap.get(minFrequency);
            DLinkedNode delNode = doubleLinkedList.deleteTail();
            map.remove(delNode.key);
        }
        DLinkedNode node = new DLinkedNode(key, value);
        insertToHead(1, node);
        map.put(key, node);
        this.minFrequency = 1;
    }

    private DLinkedNode deleteNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        frequencyMap.get(node.frequency).count--;
        if (node.frequency == minFrequency && frequencyMap.get(node.frequency).count == 0) {
            minFrequency++;
        }

        return node;
    }

    private void insertToHead(int frequency, DLinkedNode node) {
        DoubleLinkedList doubleLinkedList;
        if (frequencyMap.containsKey(frequency)) {
            doubleLinkedList = frequencyMap.get(frequency);
        } else {
            doubleLinkedList = new DoubleLinkedList();
        }
        doubleLinkedList.insertToHead(node);
        frequencyMap.put(frequency, doubleLinkedList);
    }

    private class DoubleLinkedList {
        private DLinkedNode dummyHead;
        private DLinkedNode dummyTail;
        private int count;

        public DoubleLinkedList() {
            count = 0;
            this.dummyHead = new DLinkedNode();
            this.dummyTail = new DLinkedNode();
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        public void insertToHead(DLinkedNode node) {
            DLinkedNode next = dummyHead.next;
            dummyHead.next = node;
            node.pre = dummyHead;
            next.pre = node;
            node.next = next;
            count++;
        }

        public DLinkedNode deleteTail() {
            DLinkedNode delNode = dummyTail.pre;
            delNode.pre.next = dummyTail;
            dummyTail.pre = delNode.pre;
            count--;
            return delNode;
        }
    }
}
