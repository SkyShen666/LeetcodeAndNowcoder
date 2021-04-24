public class Solution414 {
    public static void main(String[] args) {
        String str2 = new String("str01") + new String("");
        str2.intern();
        String str1 = "str01";
        System.out.println(str2 == str1);
    }
}
