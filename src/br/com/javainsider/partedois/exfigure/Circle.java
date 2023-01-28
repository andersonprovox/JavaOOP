package br.com.javainsider.partedois.exfigure;

public class Circle implements Shape{
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double surfaceArea() {
        return Math.PI * radius * radius;
    }
}
