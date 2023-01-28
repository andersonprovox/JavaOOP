package br.com.javainsider.partedois.exfigure;

public class AppFigure {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.sumSurfaceArea(new Circle(5));

        calculator.sumSurfaceArea(new Rectangle(10, 5));

        double r = calculator.sumSurfaceArea(new Square(7));

        System.out.println(r);
    }
}
