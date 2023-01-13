package br.com.javainsider.parteum;

public class Number {
    private int numberOne;
    private int numberTwo;
    private static int amountObject;

    static {
        amountObject = 0;
    }

    public Number () {
        amountObject++;
    }

    int add(int a, int b) {
        return a + b;
    }

    public static int getAmountObject() {
        return amountObject;
    }
}
