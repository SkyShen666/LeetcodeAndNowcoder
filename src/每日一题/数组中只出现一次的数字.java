package 每日一题;

import java.util.HashMap;

/**
 * Description:
 *   一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class 数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int diff = 0;
        //任何一个数字异或它自己都为0
        for (int num : array) {
            diff ^= num;
        }
        /**
         * 得到两个不同数字按位异或运算的二进制表示中最右侧第一个为1的位置
         * 并且此diff其余位上皆为0
         * 两个不同数字在diff的1那个位上是不同的，一个为1，一个为0
         * 以此就可以利用&(按位与运算)
         */
        diff &= -diff;
        for (int num : array) {
            if ((num & diff) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
