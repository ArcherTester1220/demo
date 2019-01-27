package com.archer.guava;

import com.google.common.base.CharMatcher;

public class CharMatcherTest {
    public static void main(String[] args) {
        System.out.println(CharMatcher.digit().retainFrom("mahesh123")); // only the digits
        System.out.println(CharMatcher.whitespace().trimAndCollapseFrom("     Mahesh     Parashar ", ' '));
        // trim whitespace at ends, and replace/collapse whitespace into single spaces
        System.out.println(CharMatcher.javaDigit().replaceFrom("mahesh123", "*")); // star out all digits
        System.out.println(CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom("mahesh123"));
        // eliminate all characters that aren't digits or lowercase
    }
}
