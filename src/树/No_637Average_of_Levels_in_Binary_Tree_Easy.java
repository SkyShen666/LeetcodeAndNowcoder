package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_637Average_of_Levels_in_Binary_Tree_Easy {
    /**
     * BFS(Breadth First Search)广度优先搜索
     * 借助队列实现即可，用队列暂时存储每一层的结点
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelNodeNum = queue.size();
            double sum = 0;
            for (int i = 0; i < levelNodeNum; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(sum/levelNodeNum);
        }
        return ret;
    }
}
