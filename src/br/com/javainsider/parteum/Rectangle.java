package br.com.javainsider.parteum;

public class Rectangle {
    private final double height;
    private final double base;
    private final double square;

    public Rectangle(double h, double b){
        this.height = h;
        this.base = b;
        square = h * b;
    }

    public Rectangle(double valor) {
        this(valor, valor);
    }

    double square() {
        return square;
    }

}
