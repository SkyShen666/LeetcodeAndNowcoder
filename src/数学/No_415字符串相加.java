package 数学;

public class No_415字符串相加 {
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (carry > 0 || i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = carry + x + y;
            str.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        return str.reverse().toString();
    }
}
