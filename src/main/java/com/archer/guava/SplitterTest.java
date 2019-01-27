package com.archer.guava;

import com.google.common.base.Splitter;

public class SplitterTest {
    public static void main(String[] args) {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }

}
