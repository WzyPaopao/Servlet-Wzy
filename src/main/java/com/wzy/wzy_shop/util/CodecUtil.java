package com.wzy.wzy_shop.util;

public class CodecUtil {
    public static String getSalt() {
        String words = "abcedfghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890?!@#$%^&*(){}[]./";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i ++) {
            sb.append(words.charAt((int) (Math.random() * words.length() + 1)));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt());
    }
}
