package com.archer.model.factory;

public interface IHumanFactory {

    interface IHumanType {
    }

    Human getHumanInstance(IHumanType type);

    static Human getHumanInstanceByFactoryAndType(IHumanFactory factory, IHumanType type) {
        return factory.getHumanInstance(type);
    }
}

