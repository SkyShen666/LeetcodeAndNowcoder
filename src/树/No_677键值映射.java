package 树;

// 可先做208题
// 前缀树
public class No_677键值映射 {
    private class TrieNode {
        TrieNode[] childs = new TrieNode[26];
        int val;
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public No_677键值映射() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        insert(key, val, root);
    }

    private void insert(String key, int val, TrieNode node) {
        if (node == null) {
            return;
        }
        if (key.length() == 0) {
            node.val = val;
            return;
        }

        int index = key.charAt(0) - 'a';
        if (node.childs[index] == null) {
            node.childs[index] = new TrieNode();
        }
        insert(key.substring(1), val, node.childs[index]);
    }

    public int sum(String prefix) { //相当于208题的Trie树的search
        return sum(prefix, root);
    }

    private int sum(String prefix, TrieNode node) {
        if (node == null) {
            return 0;
        }

        if (prefix.length() != 0) {
            int index = prefix.charAt(0) - 'a';
            return sum(prefix.substring(1), node.childs[index]);
        }

        int sum = node.val;
        for (TrieNode child : node.childs) {
            // 此处不需要prefix.substring(1)，因为prefix = "" 为空字符串
            sum += sum(prefix, child);
        }

        return sum;
    }
}
