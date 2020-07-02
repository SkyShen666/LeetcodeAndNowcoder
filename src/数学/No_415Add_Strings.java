package 数学;

public class No_415Add_Strings {
    public static void main(String[] args) {
        String sum = addStrings("1", "9");
        System.out.println(sum);
    }

    private static String addStrings(String num1, String num2) {
        int indexA = num1.length() - 1;
        int indexB = num2.length() - 1;
        int temp = 0;
        StringBuffer sb = new StringBuffer();
        while (indexA >= 0 || indexB >= 0 || temp == 1){
            int x = indexA < 0 ? 0 : num1.charAt(indexA--) - '0';
            int y = indexB < 0 ? 0 : num2.charAt(indexB--) - '0';
            sb.append((x + y + temp) % 10);
            temp = (x + y + temp) / 10;
        }
        return sb.reverse().toString();
    }

}
