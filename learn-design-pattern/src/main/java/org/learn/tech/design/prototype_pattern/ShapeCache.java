package org.learn.tech.design.prototype_pattern;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<Long, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(Long shapeId) throws CloneNotSupportedException {
        Shape cacheShape = shapeMap.get(shapeId);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId(1L);
        shapeMap.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId(1L);
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
