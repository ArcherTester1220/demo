package com.archer.aop.javassist;

import javassist.*;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class ClassByteTranslator implements ClassFileTransformer {


    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        //如果加载UserDaoImpl类才拦截
        if (!className.contains("com/archer")) {
            return null;
        }
        try {
            //javassist的包名是用点分割的，需要转换下
            if (className.indexOf("/") != -1) {
                className = className.replaceAll("/", ".");
            }
            CtClass ctClass = ClassPool.getDefault().get(className);
            if (ctClass.isInterface()) {
                return null;
            }
            CtMethod[] methods = ctClass.getDeclaredMethods();
            for (CtMethod m : methods) {
                m.insertBefore("{System.out.println(\"开始方法\");\n}");
            }
            return ctClass.toBytecode();

        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
