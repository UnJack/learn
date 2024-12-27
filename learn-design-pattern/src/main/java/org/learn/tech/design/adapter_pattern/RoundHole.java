package org.learn.tech.design.adapter_pattern;

import lombok.Data;

/**
 * 圆孔
 */
@Data
public class RoundHole {

    private int radius;

    public RoundHole() {
    }

    public RoundHole(int radius) {
        this.radius = radius;
    }

    public boolean fits(RoundPeg roundPeg) {
        return this.getRadius() >= roundPeg.getRadius();
    }
}
