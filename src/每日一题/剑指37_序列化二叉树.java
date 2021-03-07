package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
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
 */

public class 剑指37_序列化二叉树 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrder(root, "");
    }

    // 通过前序遍历序列化
    private String preOrder(TreeNode node, String str) {
        if (node == null) {
            str += "null,";
        } else {
            str += String.valueOf(node.val) + ",";
            str = preOrder(node.left, str);
            str = preOrder(node.right, str);
        }

        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));

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
