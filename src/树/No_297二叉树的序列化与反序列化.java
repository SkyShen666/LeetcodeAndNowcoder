package 树;
import java.util.*;
public class No_297二叉树的序列化与反序列化 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrder(root, "");
    }

    // 通过前序遍历序列化
    private String preOrder(TreeNode node, String str) {
        if (node == null) {
            str += "null,";
        } else {
            str += str.valueOf(node.val) + ",";
            str = preOrder(node.left, str);
            str = preOrder(node.right, str);
        }
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
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
