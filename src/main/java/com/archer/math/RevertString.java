package com.archer.math;


/**
 * 字符串翻转
 */
public class RevertString {


    public static void revertCharArray(char[] chars, int i, int j) {
        while (i < j) {
            chars[i] = (char) (chars[i] ^ chars[j]);
            chars[j] = (char) (chars[i] ^ chars[j]);
            chars[i] = (char) (chars[i] ^ chars[j]);
            i++;
            j--;
        }
    }


    public static String revertWorld(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        revertCharArray(chars, 0, s.length() - 1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                revertCharArray(chars, begin, i - 1);
                begin = i + 1;
            }
        }
        revertCharArray(chars, begin, chars.length - 1);
        return new String(chars);
    }


    public static void main(String[] args) {
        String input = "how are you";
        String output = revertWorld(input);
        System.out.println(output);
    }
}
