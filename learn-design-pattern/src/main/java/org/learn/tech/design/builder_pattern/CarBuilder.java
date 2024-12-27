package org.learn.tech.design.builder_pattern;

import lombok.Data;
import org.learn.tech.design.builder_pattern.product.Car;
import org.learn.tech.design.builder_pattern.product.CarType;
import org.learn.tech.design.builder_pattern.product.Engine;
import org.learn.tech.design.builder_pattern.product.GPSNavigator;
import org.learn.tech.design.builder_pattern.product.Transmission;
import org.learn.tech.design.builder_pattern.product.TripComputer;

/**
 * 汽车生成器
 */
@Data
public class CarBuilder implements Builder {

    private CarType carType;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(carType, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
