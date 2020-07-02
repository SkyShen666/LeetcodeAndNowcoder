package 每日一题;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    //方法一：冒泡思想
    public void reOrderArray(int [] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(array[j]) && !isEven(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
/**
 //方法一：新建数组
     public void reOrderArray(int [] array) {
         int oddCnt = 0;
         for (int num : array) {
             if (num % 2 != 0) {
             oddCnt++;
            }
         }
         int[] copy = array.clone();
         int i = 0;
         int j = oddCnt;
         for (int num : copy) {
             if (num % 2 != 0) {
                 array[i++] = num;
             } else {
                array[j++] = num;
             }
         }
     }
 */