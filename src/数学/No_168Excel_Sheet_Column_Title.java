package 数学;

public class No_168Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        String title = convertToTitle(1);
        System.out.println(title);
    }

    private static String convertToTitle(int n) {
        if (n == 0){
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char)(n % 26 + 'A');
    }

}
