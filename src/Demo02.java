import java.util.Arrays;

/**
 * 解法一：
 *      利用String类中现有的replace方法
 */
public class Demo02 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(stringBuffer));
    }

    public static String replaceSpace(StringBuffer str){
        return str.toString().replace(" ","%20");
    }
}
