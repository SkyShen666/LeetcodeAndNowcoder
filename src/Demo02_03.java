/**
 * 解法三：
 *      在当前字符串上进行从后往前的替换。
 */
public class Demo02_03 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("   ");
        System.out.println(replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                spaceNum++;
            }
        }
        int oldLength = str.length();
        int newLength = oldLength + spaceNum * 2;
        int oldIndex = oldLength - 1;
        int newIndex = newLength - 1;

        str.setLength(newLength);

        for(;oldLength < newLength && oldIndex >= 0;oldIndex--){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
        }
        return str.toString();
    }
}
