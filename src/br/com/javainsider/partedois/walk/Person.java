package br.com.javainsider.partedois.walk;

public class Person implements Walkable, Jumpable {
    private int steps;
    private int distancePerStep;

    @Override
    public void walk() {
        steps++;
        distancePerStep+= 10;
    }

    @Override
    public void stop() {
        steps = 0;
    }

    public void jump() {
        walk();
        walk();
    }
}
