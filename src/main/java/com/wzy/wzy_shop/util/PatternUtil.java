package com.wzy.wzy_shop.util;

import java.util.regex.Pattern;

public class PatternUtil {
    /**
     * 正则匹配工具类
     */

    public static String USER_REGEX = "^a.*";
    public static String EMAIL_REGEX = "^a.*";
    public static String PASSWORD_REGEX = "^a.*";

    public static boolean checkUserReg(String username) {
        return Pattern.matches(USER_REGEX, username);
    }
}
