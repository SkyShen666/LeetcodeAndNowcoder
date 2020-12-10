package 数学;
// 参考题解:
// https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/cong-zui-ji-chu-de-jiang-qi-ru-he-zuo-dao-jun-yun-/
public class No470用Rand7实现Rand10 {
//    public int rand10() {
//        while (true) {
//            int num = (rand7() - 1) * 7 + rand7();
//            if (num >= 40) {
//                return num % 10 + 1;
//            }
//        }
//    }
}

// 优化后的方法（利用范围外的数，减少丢弃的值，提高命中率，而提高随机数的生成效率）
//    public int rand10() {
//        while (true) {
//            int a = (rand7() - 1) * 7;
//            int b = rand7();
//            int num = a + b; // rand49
//            if (num <= 40) {
//                return num % 10 + 1;
//            }
//
//            a = num % 10; // rand9
//            b = rand7();
//            num = (a - 1) * 7 + b; // rand63
//            if (num <= 60) {
//                return num % 10 + 1;
//            }
//
//            a = num % 10; // rand3
//            b = rand7();
//            num = (a - 1) * 7 + b; // rand21
//            if (num <= 20) {
//                return num % 10 + 1;
//            }
//        }
//    }