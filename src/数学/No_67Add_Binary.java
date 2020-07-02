package 数学;

public class No_67Add_Binary {
    public static void main(String[] args) {
        String sum = addBinary("100", "110010");
        System.out.println(sum);
    }

    private static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int temp = 0;
        while (indexA >= 0 || indexB >= 0 || temp == 1){
            if(indexA >= 0 && a.charAt(indexA--) == '1'){
                temp++;
            }
            if (indexB >= 0 && b.charAt(indexB--) == '1'){
                temp++;
            }
            sb.append(temp % 2);
            temp = temp / 2;
        }
        return sb.reverse().toString();
    }


/*
  *自己写的方法，非常的笨和繁杂
  *
  private static String addBinary(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        StringBuffer sb = new StringBuffer();
        int lengthA = arrayA.length;
        int lengthB = arrayB.length;
        int temp = 0;
        while (lengthA != 0 || lengthB != 0) {
            if (lengthA == 0 && lengthB != 0) {
                if (charToInt(arrayB[lengthB - 1]) + temp == 2){
                    sb.append(0);
                }else if (charToInt(arrayB[lengthB - 1]) + temp == 0){
                    sb.append(0);
                }else {
                    sb.append(1);
                }
                temp = (charToInt(arrayB[lengthB - 1]) + temp) == 2 ? 1 : 0;
                lengthB--;
            } else if (lengthB == 0 && lengthA != 0) {
                if (charToInt(arrayA[lengthA - 1]) + temp == 2){
                    sb.append(0);
                }else if (charToInt(arrayA[lengthA - 1]) + temp == 0){
                    sb.append(0);
                }else {
                    sb.append(1);
                }
                temp = (charToInt(arrayA[lengthA - 1]) + temp) == 2 ? 1 : 0;
                lengthA--;
            } else {
                if (charToInt(arrayA[lengthA - 1]) + charToInt(arrayB[lengthB - 1]) == 1) {
                    sb.append((1 + temp) == 2 ? 0 : 1);
                    temp = (1 + temp) == 2 ? 1 : 0;
                    lengthA--;
                    lengthB--;
                } else if (charToInt(arrayA[lengthA - 1]) + charToInt(arrayB[lengthB - 1]) == 2) {
                    sb.append(0 + temp);
                    temp = 1;
                    lengthA--;
                    lengthB--;
                } else if (charToInt(arrayA[lengthA - 1]) + charToInt(arrayB[lengthB - 1]) == 0) {
                    sb.append(0 + temp);
                    temp = 0;
                    lengthA--;
                    lengthB--;
                }
            }
        }
        if (temp == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static int charToInt(char c) {
        int n = Integer.parseInt(String.valueOf(c));
        return n;
    }*/
}
