package 字符串;

public class No_925长按键入 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        // 扫描type
        while (j < typed.length()) {
            // type[j] 与 name[i] 进行匹配
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        // i == name.length() 说明name的每个字符都被匹配了
        return i == name.length() ? true : false;
    }
//    public boolean isLongPressedName(String name, String typed) {
//        int nameLen = name.length();
//        int typedLen = typed.length();
//        if (name == null) {
//            return true;
//        }
//        if (nameLen > typedLen) {
//            return false;
//        }
//
//        int p = 0;
//        int q0 = -1, q1 = 0;
//        while (p < nameLen && q1 < typedLen) {
//            if (name.charAt(p) == typed.charAt(q1)) {
//                p++;
//                q0++;
//                q1++;
//            } else {
//                if (q0 >= 0 && typed.charAt(q0) == typed.charAt(q1)) {
//                    q0++;
//                    q1++;
//                } else {
//                    return false;
//                }
//            }
//        }
//
//        if (p < nameLen) {
//            return false;
//        } else {  // p == nameLen
//            if (q1 < typedLen) {
//                while (q1 < typedLen) {
//                    if (typed.charAt(q0) != typed.charAt(q1)) {
//                        return  false;
//                    }
//                    q0++;
//                    q1++;
//                }
//            }
//        }
//        return true;
//    }
}
