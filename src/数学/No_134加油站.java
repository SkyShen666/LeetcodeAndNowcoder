package 数学;
// 参考题解:https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
//  1. 首先判断总gas能不能大于等于总cost，如果总gas不够，一切都白搭对吧；
//  2. 有序列表再就是找总（gas-cost）的最低点，不管正负（当然如果最低点都是正的话那肯定能跑完了）；
//  3. 找到最低点后，如果有解，那么解就是最低点的下一个点，因为总（gas-cost）是大于等于0的，所以前面损失的gas我从最低点下一个点开始都会拿回来！别管后面的趋势是先加后减还是先减后加，最终结果我是能填平前面的坑的。
public class No_134加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        int remain = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (min > remain) {
                res = i;
                min = remain;
            }
        }
        return remain >= 0 ? (res + 1) % gas.length : -1;
    }
}
