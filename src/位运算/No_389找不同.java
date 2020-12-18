package 位运算;

// 位运算：异或
public class No_389找不同 {
    public char findTheDifference(String s, String t) {
        char ret = 0;

        for (char c : s.toCharArray()) {
            // 不能这样写：ret = ret ^ c;
            // error: incompatible types: possible lossy conversion from int to char
            ret ^= c;
        }

        for (char c : t.toCharArray()) {
            ret ^= c;
        }

        return ret;
    }
}

//  方法一：计数
//
//    public char findTheDifference(String s, String t) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        for (int i = 0; i < t.length(); i++) {
//            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0) {
//                return t.charAt(i);
//            } else {
//                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
//            }
//        }
//
//        return 'a';
//    }
