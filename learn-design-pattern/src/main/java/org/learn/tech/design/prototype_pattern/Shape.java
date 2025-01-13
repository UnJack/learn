package org.learn.tech.design.prototype_pattern;

import lombok.Data;

@Data
public abstract class Shape implements Cloneable {

    private Long id;
    protected String type;

    abstract void draw();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
