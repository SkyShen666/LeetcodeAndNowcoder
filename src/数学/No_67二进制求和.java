package 数学;

public class No_67二进制求和 {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0 && a.charAt(i) == '1') {
                carry++;
            }
            i--;
            if (j >= 0 && b.charAt(j) == '1') {
                carry++;
            }
            j--;
            str.append(carry % 2);
            carry = carry / 2;
        }

        return str.reverse().toString();
    }
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
