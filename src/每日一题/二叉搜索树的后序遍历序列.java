package 每日一题;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int low, int high) {
        if (high - low <= 1)
            return true;
        int rootVal = sequence[high];
        int cutIdx = low;
        while (cutIdx < high && sequence[cutIdx] <= rootVal)
            cutIdx++;
        for (int i = cutIdx; i < high; i++) {
            if (sequence[i] < rootVal)
                return false;
        }
        return verify(sequence, low, cutIdx - 1)
                && verify(sequence, cutIdx, high - 1);
    }
}
