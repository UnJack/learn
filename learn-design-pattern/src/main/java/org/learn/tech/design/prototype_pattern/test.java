package org.learn.tech.design.prototype_pattern;

public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape(1L);
        System.out.println(shape.getType());
    }
}
