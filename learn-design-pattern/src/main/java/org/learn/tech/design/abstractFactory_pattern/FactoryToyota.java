package org.learn.tech.design.abstractFactory_pattern;

/**
 * Created by jimjian on 2017/3/15.
 */
public class FactoryToyota implements FactoryCar {
    @Override
    public Car createCar() {
        return new CarToyota();
    }
}
