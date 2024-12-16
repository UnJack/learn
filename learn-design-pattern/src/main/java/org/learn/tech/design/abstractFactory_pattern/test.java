package org.learn.tech.design.abstractFactory_pattern;

/**
 * Created by jimjian on 2017/3/15.
 */
public class test {
    public static void main(String[] args) {
        FactoryCar carFactory = new FactoryBMW();
        CarBMW bmwCar = (CarBMW) carFactory.createCar();
        bmwCar.start();
    }
}
