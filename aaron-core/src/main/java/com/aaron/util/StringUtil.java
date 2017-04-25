package com.aaron.util;

/**
 * Created by pzw on 2/2/2016.
 */
public class StringUtil {
    public StringUtil() {
    }

    public static boolean isNotEmpty(String s) {
        return s != null && !"".equals(s) && !"null".equals(s);
    }

    public static boolean isEmpty(String s) {
        return !isNotEmpty(s);
    }

    public static StringBuilder deleteLastChar(StringBuilder strBuilder) {
        if(strBuilder != null && strBuilder.length() != 0) {
            if(strBuilder.length() > 0) {
                strBuilder.deleteCharAt(strBuilder.length() - 1);
            }
            return strBuilder;
        } else {
            return strBuilder;
        }
    }
}
