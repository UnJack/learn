package org.learn.tech.design.adapter_pattern;

import lombok.Data;

/**
 * 方钉
 */
@Data
public class SquarePeg {

    private double width;

    public SquarePeg() {
    }

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getSquare() {
        return Math.pow(width, 2);
    }
}
