package org.learn.tech.design.builder_pattern.product;

import lombok.Data;

/**
 * 产品特征-GPS导航器
 */
@Data
public class GPSNavigator {

    private String route;

    public GPSNavigator() {
        this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
    }

    public GPSNavigator(String manualRoute) {
        this.route = manualRoute;
    }

}