package com.archer.mode.factory;

import java.lang.reflect.UndeclaredThrowableException;

public class HumanFactory2 implements IHumanFactory {

    public enum HumanType implements IHumanType {
        MAN("MAN", Menfolk.class),
        WOMAN("WOMAN", Female.class);

        private String name;
        private Class<? extends Human> cls;

        HumanType(String name, Class<? extends Human> cls) {
            this.name = name;
            this.cls = cls;
        }

        public String getName() {
            return name;
        }

        public Class<? extends Human> getCls() {
            return cls;
        }

        public static HumanType of(String name) {
            for (HumanType type : HumanType.values()) {
                if (type.getName().equals(name)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("unknow HumanType :" + name);
        }
    }

    private HumanFactory2() {
    }

    private volatile static HumanFactory2 hf = null;

    public static HumanFactory2 get() {
        if (hf != null) {
            return hf;
        }
        synchronized (HumanFactory2.class) {
            return hf = hf == null ? new HumanFactory2() : hf;
        }
    }


    @Override
    public Human getHumanInstance(IHumanType type) {
        if (type.getClass() != HumanType.class) {
            throw new RuntimeException("工厂与类型不匹配，请使用HumanFactory2.HumanType类型");
        }
        HumanType ty = (HumanType) type;
        Class<? extends Human> cls = ty.getCls();
        try {
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new UndeclaredThrowableException(e);
        }
    }
}
