package A剑指Offer;


import java.util.ArrayList;
import java.util.List;

public class No_95不同的二叉搜索树II {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return getAns(1,n);
    }

    private static List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //此时没有数字，将null放入ans
        if (start > end) {
            ans.add(null);
            return ans;
        }

        //此时仅有一个数字
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }

        //尝试以每个数字i为根节点
        for (int i = start; i <= end; i++) {
            //所有可能的左子树
            List<TreeNode> leftTrees = getAns(start,i - 1);
            //有所可能的右子树
            List<TreeNode> rightTrees = getAns(i + 1, end);
            //将左右子树的所有可能组合起来
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        for (TreeNode node : list) {
            System.out.println(node.val);
        }
    }
}
