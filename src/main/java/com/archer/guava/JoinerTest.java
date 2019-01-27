package com.archer.guava;

import com.google.common.base.Joiner;

import java.util.Arrays;

public class JoinerTest {
    public static void main(String args[]) {
        JoinerTest tester = new JoinerTest();
        tester.testJoiner();
    }

    private void testJoiner() {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
        System.out.println(Joiner.on(",").skipNulls().join(Arrays.asList("3", "2", null)));
    }
}
