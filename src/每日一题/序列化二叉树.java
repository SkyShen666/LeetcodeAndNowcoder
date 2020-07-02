package 每日一题;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树

 二叉树的序列化是指：
    把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
    从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
    序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

 */
public class 序列化二叉树 {
    private String deserializeStr;

    String Serialize(TreeNode root) {
        if (root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    //通过前序序列化的字符串建树
    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String c;
        if (index == -1) { //只有一个结点
            c = deserializeStr;
        } else { //有至少两个结点
            c = deserializeStr.substring(0, index);
        }
        if (index == -1) {
            deserializeStr = "";
        } else {
            deserializeStr = deserializeStr.substring(index + 1);
        }
        //建立结点
        if (c.equals("#"))  //一定注意 == 和 equals()的区别
            return null;
        int val = Integer.valueOf(c);
        TreeNode node = new TreeNode(val);
        node.left = Deserialize();
        node.right = Deserialize();
        return node;
    }
}
