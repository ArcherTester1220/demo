package com.archer.mode.factory;

public class HumanFactory2Test {
    public static void main(String[] args) {
        Human hm = IHumanFactory.getHumanInstanceByFactoryAndType(HumanFactory2.get(), HumanFactory2.HumanType.MAN);
        Human hm2 = IHumanFactory.getHumanInstanceByFactoryAndType(HumanFactory2.get(), HumanFactory2.HumanType.WOMAN);
        hm.sleep();
        hm2.sleep();

        HumanFactory2.HumanType type = HumanFactory2.HumanType.of(HumanFactory2.HumanType.WOMAN.getName());
        Class<? extends Human> cls = type.getCls();
        try {
            cls.newInstance().sleep();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
