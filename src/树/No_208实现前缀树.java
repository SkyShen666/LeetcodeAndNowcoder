package 树;

/**
 * Trie:前缀树（字典树）
 * 参考题解：
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/trie-tree-de-shi-xian-gua-he-chu-xue-zhe-by-huwt/
 */
public class No_208实现前缀树 {
    private class TrieNode {
        TrieNode[] childs = new TrieNode[26];
        boolean isLeaf;
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public No_208实现前缀树() {
         root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, TrieNode node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }

        int index = word.charAt(0) - 'a';
        if (node.childs[index] == null) {
            node.childs[index] = new TrieNode();
        }
        insert(word.substring(1), node.childs[index]);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }

        int index = word.charAt(0) - 'a';

        return search(word.substring(1), node.childs[index]);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }

        int index = prefix.charAt(0) - 'a';

        return startsWith(prefix.substring(1), node.childs[index]);
    }
}
