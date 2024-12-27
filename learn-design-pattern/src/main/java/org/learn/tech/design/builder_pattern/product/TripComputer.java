package org.learn.tech.design.builder_pattern.product;

import lombok.Data;

/**
 * 产品特征-行车电脑
 */
@Data
public class TripComputer {

    private Car car;

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}