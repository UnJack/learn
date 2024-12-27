package org.learn.tech.design.builder_pattern;

import org.learn.tech.design.builder_pattern.product.CarType;
import org.learn.tech.design.builder_pattern.product.Engine;
import org.learn.tech.design.builder_pattern.product.GPSNavigator;
import org.learn.tech.design.builder_pattern.product.Transmission;
import org.learn.tech.design.builder_pattern.product.TripComputer;

/**
 * 通用生成器接口
 */
public interface Builder {

    void setCarType(CarType carType);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
