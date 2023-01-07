package com.example.customermanager;

public class Utils {
    /**
     * 文字列前後のダブルクォーテーションを削除するFunction
     * @param str 文字列
     * @return 前後のダブルクォーテーションを削除した文字列
     */
    public static String trimDoubleQuot(String str) {
        char c = '"';
        if(str.charAt(0) == c && str.charAt(str.length()-1) == c) {
            return str.substring(1, str.length()-1);
        }else {
            return str;
        }
    }
}
