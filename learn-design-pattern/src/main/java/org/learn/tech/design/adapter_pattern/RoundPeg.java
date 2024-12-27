package org.learn.tech.design.adapter_pattern;

import lombok.Data;

/**
 * 圆钉
 */
@Data
public class RoundPeg {

    private double radius;

    public RoundPeg() {
    }

    public RoundPeg(int radius) {
        this.radius = radius;
    }
}