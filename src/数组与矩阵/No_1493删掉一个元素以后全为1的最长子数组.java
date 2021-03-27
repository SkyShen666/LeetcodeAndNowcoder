package 数组与矩阵;

public class No_1493删掉一个元素以后全为1的最长子数组 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int a = 0; // a 存中间有一个“非1”的和
        int b = 0; // b 存连续1的和
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                a = b; // 遇到一个0，更新a = b
                b = 0; // 遇到0，此时b = 0
            } else {
                a++;
                b++;
            }
            maxLen = Math.max(maxLen, a); // 扫描过程保存最大的 a 值
        }
        if (maxLen == n) { // 最后处理一下全1特例
            maxLen--;
        }

        return maxLen;
    }
}
