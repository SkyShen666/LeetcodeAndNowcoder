package 分治;

import java.util.ArrayList;
import java.util.List;

/**
 * 分治法：就是把一个复杂的问题分成两个或更多的相同或相似的子问题，再把子问题分成更小的子问题……
 * 直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。
 * 此题可以理解为**x op y ** ,以算数操作符为分隔符，可以把原问题分为:x和y两个子问题，
 * 而左右两个x和y又可以分别分为 **x1 op y1**，**x2 op y2**,以此类推，直到子部分只有一个数为止。
 */
public class No_241为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        int n = input.length();

        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int x : left) {
                    for (int y : right) {
                        switch (c) {
                            case '+':
                                list.add(x + y);
                                break;
                            case '-':
                                list.add(x - y);
                                break;
                            case '*':
                                list.add(x * y);
                                break;
                        }
                    }
                }
            }
        }

        if (list.size() == 0) {
            list.add(Integer.valueOf(input));
        }

        return list;
    }
}
