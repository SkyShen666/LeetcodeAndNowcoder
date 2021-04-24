package A剑指Offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化：
 * 把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改.
 *
 * 二叉树的反序列化：
 * 根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * #：表示空节点
 * !: 表示一个结点值的结束(value!)
 *
 * 注意的点：
 * 相比于题目给定的 "[1,2,3,null,null,4,5]" 会多输出 null 。
 * 但本题的测试的是 序列化 和 反序列化是否可逆，因此 “序列化列表的形式” 并未限制，只要两个函数可以互逆就好啦
 */

public class 剑指37_序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return preorder(root, sb);
    }

    // 通过前序遍历序列化
    private String preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
        } else {
            sb.append(String.valueOf(node.val) + ",");
            preorder(node.left, sb);
            preorder(node.right, sb);
        }

        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        // 转化成
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));

        return buildTree(dataList);
    }

    // 根据前序序列，创建树
    private TreeNode buildTree(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = buildTree(list);
        root.right = buildTree(list);

        return root;
    }
}
