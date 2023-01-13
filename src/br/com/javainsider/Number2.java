package br.com.javainsider;

public class Number2 {
    private static int instances;
    private final int number;

    private Number2(int number) {
        this.number = number;
        instances++;
    }

    public int getNumber() {
        return number;
    }

    public static Number2 add (Number2 n1, Number2 n2) {
        return new Number2(n1.getNumber() + n2.getNumber());
    }

    public static int getInstances() {
        return instances;
    }

    public static Number2 newNumber(int n) {
        return new Number2(n);
    }
}
