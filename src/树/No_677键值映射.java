package 树;

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
public class No_677键值映射 {
    private class Node {
        Node[] childs = new Node[26];
        int value;
    }

     /** Initialize your data structure here. */
    public No_677键值映射() {

    }

    Node root = new Node();

    public void insert(String key, int val) {
        insert(key , val , root);
    }

    private void insert(String key, int val, Node node) {
        if (node == null) return;
        if (key.length() == 0) {
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (node.childs[index] == null) {
            node.childs[index] = new Node();
        }
        insert(key.substring(1) , val , node.childs[index]);
    }

    public int sum(String prefix) { //相当于208题的Trie树的search
        return sum(prefix , root);
    }

    private int sum(String prefix, Node node) {
        if (node == null) return 0;
        if (prefix.length() != 0) {
            int index = indexForChar(prefix.charAt(0));
            return sum(prefix.substring(1) , node.childs[index]);
        }
        int sum = node.value;
        for (Node child : node.childs) {
            sum += sum(prefix , child);
        }
        return sum;
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
