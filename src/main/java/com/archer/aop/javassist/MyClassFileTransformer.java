package com.archer.aop.javassist;

import java.lang.instrument.Instrumentation;

public class MyClassFileTransformer {
    public static void premain(String options, Instrumentation instrumentation) {
        instrumentation.addTransformer(new ClassByteTranslator());
    }
}
